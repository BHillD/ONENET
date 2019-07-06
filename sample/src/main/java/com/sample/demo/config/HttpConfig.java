package com.sample.demo.config;

import okhttp3.OkHttpClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * date: 2019/7/1
 * description: OKHTTP 配置类
 */

@Configuration
public class HttpConfig {
    @Bean
    public OkHttpClient getOkHttpClient(){
        return new OkHttpClient();
    }

    @Bean
    public Callback getCallback(){
        return new Callback();
    }

}
