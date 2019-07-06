package com.sample.demo.mq;

import com.alibaba.fastjson.JSONObject;
import com.google.protobuf.InvalidProtocolBufferException;
import org.eclipse.paho.client.mqttv3.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.logging.Logger;


public class PushCallback implements MqttCallback {

    @Autowired
    com.sample.demo.utils.Queue Queue;

    private IMqttAsyncClient Client;
    private static final Logger logger = Logger.getLogger(PushCallback.class.getCanonicalName());
    private MqClient mqClient;
    private int reConnTimes = 0;

    public PushCallback(MqClient client) {
        mqClient = client;
    }

    @Override
    public void connectionLost(Throwable cause) {
        logger.info("connect is losted,and try to reconnect");
        while(true){
            if(mqClient.reConnect()){
                break;
            }
            try {
                if(reConnTimes++ > 20){//前20次每秒重连一次
                    Execute.sleep(1000);
                }else{//超过20次后没10s重连一次
                    Execute.sleep(10000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void messageArrived(String topic, MqttMessage message) throws InvalidProtocolBufferException {
        byte[] payload = message.getPayload();
        OnenetMq.Msg obj = OnenetMq.Msg.parseFrom(payload);
        System.out.println(new String(obj.getData().toByteArray()));
        JSONObject json = (JSONObject) JSONObject.parseObject(new String(obj.getData().toByteArray()));
        Queue.put(json);
    }

    @Override
    public void deliveryComplete(IMqttDeliveryToken token) {
        Client = token.getClient();
    }


}
