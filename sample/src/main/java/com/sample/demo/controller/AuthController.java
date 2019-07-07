package com.sample.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.sample.demo.model.User;
import com.sample.demo.service.AuthService;
import com.sample.demo.service.MailService;
import com.sample.demo.utils.Constant;
import com.sample.demo.utils.Response;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * date: 2019/6/21
 * description: 登录认证相关操作
 */


@CrossOrigin(allowCredentials = "true")
@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private MailService mailService;

    @Autowired
    private DefaultKaptcha defaultKaptcha;

    @Autowired
    private AuthService authService;

    @GetMapping("/captcha")
    public void getCaptcha(HttpServletResponse response) throws IOException {
        byte[] captchaChallengeAsJpeg = null;
        ByteArrayOutputStream jpegOutputStream = new ByteArrayOutputStream();
        try {
            String createText = defaultKaptcha.createText();
            BufferedImage challenge = defaultKaptcha.createImage(createText);
            System.out.println(SecurityUtils.getSubject().getSession());
            SecurityUtils.getSubject().getSession().setAttribute("code",createText);
            ImageIO.write(challenge, "jpg", jpegOutputStream);
        } catch (IllegalArgumentException e) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        captchaChallengeAsJpeg = jpegOutputStream.toByteArray();
        response.setHeader("Cache-Control", "no-store");
        response.setHeader("Pragma", "no-cache");
        response.setDateHeader("Expires", 0);
        response.setContentType("image/jpeg");
        ServletOutputStream responseOutputStream = response.getOutputStream();
        responseOutputStream.write(captchaChallengeAsJpeg);
        responseOutputStream.flush();
        responseOutputStream.close();
    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody JSONObject obj){
        String username = obj.getString(Constant.username);
        String password = obj.getString(Constant.password);
        String code = obj.getString(Constant.captcha);
        if(StringUtils.isAnyBlank(username, password, code)){
            return Response.unauth(Constant.infoerr);
        }
        if(!code.equals(SecurityUtils.getSubject().getSession().getAttribute(Constant.key))){
            return Response.unauth(Constant.infoerr);
        }
        return authService.login(username, password);
    }

    @PostMapping("/applogin")
    public ResponseEntity appLogin(@RequestBody JSONObject obj){
        String username = obj.getString(Constant.username);
        String password = obj.getString(Constant.password);
        if(StringUtils.isAnyBlank(username, password)){
            return Response.unauth(Constant.err);
        }
        return authService.login(username, password);
    }

    @GetMapping("/logout")
    public ResponseEntity logout(){
        SecurityUtils.getSubject().logout();
        return Response.ok(Constant.succ);
    }

    @PostMapping("/regist")
    public ResponseEntity regist(@RequestBody JSONObject obj){
        if(authService.registUser(obj)){
            User user = (User) obj.toJavaObject(User.class);
            mailService.sendMail(user.getEmail(),"欢迎注册现代农业管理系统", "注册成功");
            return Response.ok(Constant.succ);
        }
        return Response.unavailable(Constant.err);
    }

    @PutMapping("/user")
    public ResponseEntity update(@RequestBody JSONObject obj){
        User user = obj.toJavaObject(User.class);
        if(StringUtils.isAnyBlank(user.getName(), user.getHobby())){
            return Response.unavailable(Constant.err);
        }
        authService.update(user);
        return Response.ok(Constant.succ);
    }
}
