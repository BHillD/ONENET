package com.sample.demo.mq;


import com.alibaba.fastjson.JSONObject;

import com.sample.demo.model.*;
import com.sample.demo.service.ForestService;
import com.sample.demo.service.MeteorologicalService;
import com.sample.demo.service.WebSocketService;

import com.sample.demo.utils.Queue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * date: 2019/6/21
 * description: 子线程 负责ONENET平台数据持久化和转发功能
 */

public class Execute extends Thread {

    @Autowired
    WebSocketService webSocketService;

    @Autowired
    MeteorologicalService meteorologicalService;

    @Autowired
    ForestService forestService;

    @Autowired
    @Qualifier("meteo")
    String[] meteo;

    @Autowired
    @Qualifier("forest")
    String[] forest;


    public void run(){
        while(true){
            if(Queue.isEmpty()){
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                JSONObject json = (JSONObject) Queue.take();
                JSONObject appProperty =(JSONObject) json.get("appProperty");
                String dataTimestamp = appProperty.getString("dataTimestamp");
                String deviceId = appProperty.getString("deviceId");
                String body = (String)json.getString("body");
                String[] data = body.split("&");
                if(data.length == 1){
                    if(deviceId.equals("528381333")){
                        meteorologicalService.updateStandard(meteo[data[0].charAt(0)-'a'], data[0].substring(1,data[0].length()-1));
                    } else {
                        forestService.updateStandard(forest[data[0].charAt(0)-'a'], data[0].substring(1,data[0].length()-1));
                    }
                }else {
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    if(deviceId.equals("528381333")){
                        System.out.println("time");
                        webSocketService.meteor(body.toString());
                        Met_envir environ = new Met_envir(data[8], data[2], data[4], data[3]);
                        Met_soil soil = new Met_soil(data[6], data[7]);
                        Met_atm atm = new Met_atm(data[9], data[0], data[1], data[5]);
                        meteorologicalService.addEnviron(environ);
                        meteorologicalService.addSoil(soil);
                        meteorologicalService.addAtm(atm);
                        meteorologicalService.addDate(simpleDateFormat.format(new Date(Long.parseLong(dataTimestamp))));
                    } else {
                        webSocketService.forest(body.toString());
                        Forest_soil soil = new Forest_soil(data[7], data[6], data[5], data[8]);
                        Forest_atm atm = new Forest_atm(data[2], data[0], data[3], data[1]);
                        Fisheries fisheries = new Fisheries(data[4],data[9]);
                        forestService.addFisherise(fisheries);
                        forestService.addForestAtm(atm);
                        forestService.addForestSoil(soil);
                        forestService.addDate(simpleDateFormat.format(new Date(Long.parseLong(dataTimestamp))));
                    }
                }
            }
        }
    }
}
