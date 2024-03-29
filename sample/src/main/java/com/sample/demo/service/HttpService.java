package com.sample.demo.service;

import com.alibaba.fastjson.JSONObject;
import com.sample.demo.config.Callback;
import okhttp3.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

/**
 * date: 2019/6/21
 * description: 实现发送HTTP请求服务类
 */

@Service
public class HttpService {

    @Autowired
    private  OkHttpClient client;

    @Autowired
    private  Callback callback;

    private static String resource = "http://api.heclouds.com/nbiot?obj_id=3341&imei";
    private static String write = "http://api.heclouds.com/nbiot?obj_id=3341&obj_inst_id=0&mode=1&imei=";
    private static String met = "869662034516721";
    private static String forest = "869662034516341";
    private static final MediaType json = MediaType.parse("application/json; charset=utf-8");
    private static String api_key = "2uNWsp=IdAWpfUsEYpFV5xg9WZw=";


    public void post(JSONObject obj, boolean flag){
        RequestBody body = RequestBody.create(json, obj.toJSONString());
        Request request = null;
        if(flag == true){
            request = new Request.Builder().url(write + met).header("api-key", api_key).post(body).build();
        }else {
            request = new Request.Builder().url(write + forest).header("api-key",api_key ).post(body).build();
        }
        client.newCall(request).enqueue(callback);
    }

    public void get(JSONObject obj, boolean flag){
        RequestBody body = RequestBody.create(json, obj.toJSONString());
        Request request = null;
        if(flag == true){
            request = new Request.Builder().url(resource + met).header("api-key", api_key).post(body).build();
        }else {
            request = new Request.Builder().url(resource + forest).header("api-key",api_key ).post(body).build();
        }
        client.newCall(request).enqueue(callback);
    }
}
