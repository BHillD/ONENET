package com.sample.demo.controller;

import com.sample.demo.model.User;
import com.sample.demo.service.AuthService;
import com.sample.demo.service.FastdfsService;
import com.sample.demo.utils.Response;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;

/**
 * date: 2019/6/25
 * description: 文件上传相关操作
 */

@CrossOrigin(allowCredentials = "true")
@RestController
@RequestMapping("/upload")
public class UploadController {


    @Autowired
    FastdfsService fastdfsService;

    @Autowired
    private AuthService authService;


    @PostMapping(path = "/image")
    public ResponseEntity image(@RequestParam("file") MultipartFile image){
        if(image == null){
            return Response.unavailable();
        }
        String prefix = image.getOriginalFilename().substring(image.getOriginalFilename().lastIndexOf("."));
        InputStream inputStream = null;
        try {
            inputStream = image.getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        long size = image.getSize();
        User user = (User) SecurityUtils.getSubject().getSession().getAttribute("user");
        String url = "http://106.15.227.37:81/" + fastdfsService.upload(inputStream, prefix, size);
        String username = user.getUsername();
        authService.updateHeadPort(url, username);
        return Response.ok(url);
    }

}
