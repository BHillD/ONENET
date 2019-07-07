package com.sample.demo.utils;

import com.alibaba.fastjson.JSONObject;

import java.util.LinkedList;
import java.util.List;

/**
 * date: 2019/6/25
 * description: HTTP请求消息 封装工具类
 */

public class Message {
    public static JSONObject write(String message){
        JSONObject obj = new JSONObject();
        obj.put("val", message);
        obj.put("res_id", 5527);
        List<JSONObject> data = new LinkedList<>();
        data.add(obj);
        JSONObject body = new JSONObject();
        body.put("data", data);
        return body;
    }

    public static String value(String[] standad, String value, String name){
        String msg = null;
        for(int i = 0; i <= 9; i++){
            if(name.equals(standad[i])){
                char start = (char)('a' + i);
                msg = start + value + 'e';
                return msg;
            }
        }
        return null;
    }
}
