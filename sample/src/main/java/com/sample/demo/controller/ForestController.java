package com.sample.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.sample.demo.service.ForestService;
import com.sample.demo.service.HttpService;
import com.sample.demo.utils.Message;
import com.sample.demo.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * date: 2019/6/21
 * description: 气象相关操作
 */


@CrossOrigin(allowCredentials = "true")
@RequestMapping("/forest")
@RestController
public class ForestController {

    @Autowired
    private ForestService forestService;

    @Autowired
    private HttpService httpService;

    @Autowired
    @Qualifier("forest")
    private String[] forest;


    @GetMapping("/standard")
    public ResponseEntity getStandara(@RequestParam("name") String row){
        return Response.ok(forestService.getStandard(row));
    }

    @PutMapping("/standard")
    public ResponseEntity updateStandard(@RequestBody JSONObject obj){
        String name = obj.getString("name");
        String value = obj.getString("value");
        httpService.post(Message.write(Message.value(forest, value, name)), false);
        forestService.updateStandard(name, value);
        return Response.ok();
    }

    @GetMapping("/update")
    public ResponseEntity updateData(){
        httpService.get(false);
        return Response.ok();
    }

}
