package com.sample.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

/**
 * date: 2019/6/21
 * description: WEBSOCKET转发服务类
 */

@Service
public class WebSocketService {

    @Autowired
    private SimpMessagingTemplate template;


    public void meteor(String message){
        this.template.convertAndSend("/topic/meteor",message);
    }


    public void forest(String message){
        this.template.convertAndSend("/topic/forest", message);
    }
}
