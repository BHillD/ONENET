package com.sample.demo.config;

import com.sample.demo.mq.Execute;
import com.sample.demo.mq.MqClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * date: 2019/6/21
 * description: ONENET平台对接配置类
 */


@Configuration
public class OneNetConfig {
    @Bean
    public MqClient mqClient(){
        MqClient mqClient = new MqClient();
        mqClient.connect();
        return mqClient;
    }

    @Bean
    public Execute thread(){
        Execute execute = new Execute();
        execute.start();
        return execute;
    }

    @Bean("meteo")
    public String[] meteo(){
        String[] meteo = new String[10];
        meteo[0] = "max_atm_tem";
        meteo[1] = "max_atm_hum";
        meteo[2] = "max_envir_rain";
        meteo[3] = "max_envir_sp";
        meteo[4] = "max_envir_dir";
        meteo[5] = "max_atm_pre";
        meteo[6] = "max_soil_tem";
        meteo[7] = "max_soil_hum";
        meteo[8] = "mmax_envir_illum";
        meteo[9] = "max_atm_o2";
        return meteo;
    }

    @Bean("forest")
    public String[] forest(){
        String[] forest = new String[11];
        forest[0] = "max_atm_tem";
        forest[1] = "max_atm_hum";
        forest[2] = "max_atm_co2";
        forest[3] = "max_atm_smoke";
        forest[4] = "max_water_tem";
        forest[5] = "max_soil_tem";
        forest[6] = "max_soil_hum";
        forest[7] = "max_soil_nity";
        forest[8] = "max_soil_conduct";
        forest[9] = "max_water_tur";
        forest[10] = "max_ox";
        return forest;
    }

    @Bean
    public LinkedBlockingQueue linkedBlockingQueue(){
        return new LinkedBlockingQueue();
    }
}
