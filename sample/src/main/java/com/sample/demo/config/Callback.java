package com.sample.demo.config;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.sample.demo.service.WebSocketService;
import okhttp3.Call;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;

/**
 * date: 2019/7/1
 * description: OKHTTP Callbcak接口实现类
 */

public class Callback implements okhttp3.Callback {

    @Autowired
    WebSocketService webSocketService;

    @Override
    public void onFailure(Call call, IOException e) {

    }

    @Override
    public void onResponse(Call call, Response response) throws IOException {
        ResponseBody body = response.body();
        if(!JSON.parseObject(body.string()).getString("errno").equals("0")){
            return;
        }
        JSONObject message =(JSONObject) JSON.parseObject(body.string()).getJSONObject("data").getJSONObject("res").getJSONObject("val");
        JSONObject device =(JSONObject) JSON.parseObject(body.string()).getJSONObject("data").getJSONObject("res").getJSONObject("res_id");
        if(device.toString().equals("3341")){
            webSocketService.meteor(message.toString());
        }else {
            webSocketService.forest(message.toString());
        }
    }
}
