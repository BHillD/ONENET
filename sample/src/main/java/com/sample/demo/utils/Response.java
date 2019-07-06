package com.sample.demo.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * date: 2019/6/21
 * description: HTTP返回信息封装类
 */

public class Response {


    public static ResponseEntity ok(){ return new ResponseEntity(HttpStatus.OK); }

    public static ResponseEntity ok(Object obj){
        return new ResponseEntity(obj, HttpStatus.OK);
    }

    public static ResponseEntity unauth(){
        return new ResponseEntity(HttpStatus.UNAUTHORIZED);
    }

    public static ResponseEntity unauth(Object obj){
        return new ResponseEntity(obj, HttpStatus.UNAUTHORIZED);
    }

    public static ResponseEntity forbidden(){
        return new ResponseEntity(HttpStatus.FORBIDDEN);
    }

    public static ResponseEntity unavailable(){
        return new ResponseEntity(HttpStatus.SERVICE_UNAVAILABLE);
    }

    public static ResponseEntity unavailable(Object obj){
        return new ResponseEntity(obj, HttpStatus.SERVICE_UNAVAILABLE);
    }
}
