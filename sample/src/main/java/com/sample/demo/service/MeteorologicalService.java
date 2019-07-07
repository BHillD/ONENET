package com.sample.demo.service;

import com.alibaba.fastjson.JSONObject;
import com.sample.demo.mapper.MeteorologicalMapper;
import com.sample.demo.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

/**
 * date: 2019/6/21
 * description: 气象站相关操作类
 */


@Service
public class MeteorologicalService {


    @Autowired
    MeteorologicalMapper meteorologicalMapper;


    @Autowired
    @Qualifier("meteo")
    String[] meteo;

    public void addSoil(Met_soil soil){
        meteorologicalMapper.addMetSoil(soil); }

    public void addAtm(Met_atm atm){ meteorologicalMapper.addMetAtm(atm); }

    public void addEnviron(Met_envir environ){ meteorologicalMapper.addMetEnviron(environ); }

    public void addDate(String date){ meteorologicalMapper.addMetDate(date); }

    public BigDecimal getStandard(String name){
        return meteorologicalMapper.getStandard(name);
    }

    public JSONObject getData(){
        JSONObject obj = new JSONObject();
        obj.put("met_atm", meteorologicalMapper.getMetAtm());
        obj.put("met_soil", meteorologicalMapper.getMetSoil());
        obj.put("met_envir",meteorologicalMapper.getMetEnvir());
        return obj;
    }

    public JSONObject updateStandard(String name, String value){
        meteorologicalMapper.updateStandard(name, value);
        JSONObject json = new JSONObject();
        json.put("name", name);
        json.put("value", value);
        return json;
    }
}
