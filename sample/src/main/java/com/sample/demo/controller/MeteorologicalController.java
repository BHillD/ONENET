package com.sample.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.sample.demo.service.HttpService;
import com.sample.demo.service.MeteorologicalService;
import com.sample.demo.utils.Message;
import com.sample.demo.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

/**
 * date: 2019/6/21
 * description: 渔林相关操作
 */

@CrossOrigin(allowCredentials = "true")
@RestController
@RequestMapping("/meteorological")
public class MeteorologicalController {

    @Autowired
    private MeteorologicalService meteorologicalService;

    @Autowired
    private HttpService httpService;

    @Autowired
    @Qualifier("meteo")
    private String[] meteo;


    @GetMapping("/standard")
    public BigDecimal getStandard(@RequestParam("name") String name){
        return meteorologicalService.getStandard(name);
    }

    @PutMapping("/standard")
    public ResponseEntity updateStandard(@RequestBody JSONObject obj){
        String name = obj.getString("name");
        String value = obj.getString("value");
        httpService.post(Message.write(Message.value(meteo, name, value)), true);
        meteorologicalService.updateStandard(name, value);
        return Response.ok();
    }

    @GetMapping("/update")
    public ResponseEntity updateData(){
        httpService.get(true);
        return Response.ok();
    }

}
