package com.sample.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.sample.demo.service.ForestService;
import com.sample.demo.service.HttpService;
import com.sample.demo.service.MeteorologicalService;
import com.sample.demo.service.WebSocketService;
import com.sample.demo.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;

/**
 * date: 2019/6/25
 * description: APP相关操作
 */

@RestController
@RequestMapping("/app")
public class AppController {


    @Autowired
    private MeteorologicalService meteorologicalService;

    @Autowired
    private ForestService forestService;


    @GetMapping("/data")
    public ResponseEntity getData(){
        List<JSONObject> list = new LinkedList<>();
        list.add(meteorologicalService.getData());
        list.add(forestService.getData());
        return Response.ok(list);
    }

}
