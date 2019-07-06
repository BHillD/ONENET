package com.sample.demo.utils;

import com.alibaba.fastjson.JSONObject;


import java.util.concurrent.LinkedBlockingQueue;

/**
 * date: 2019/6/25
 * description: 线程共用队列
 */

public class Queue {

    private static LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();



    public static synchronized void put(JSONObject obj){
        try {
            linkedBlockingQueue.put(obj);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static synchronized Object take(){
        try {
            return linkedBlockingQueue.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new Exception();
    }

    public static synchronized boolean isEmpty(){
        return linkedBlockingQueue.isEmpty();
    }
}
