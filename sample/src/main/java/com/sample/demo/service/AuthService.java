package com.sample.demo.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.sample.demo.mapper.UserMapper;
import com.sample.demo.model.User;
import com.sample.demo.utils.Response;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * date: 2019/6/21
 * description: 实现登录认证相关服务类
 */

@Service
public class AuthService {

    @Autowired
    UserMapper userMapper;

    public boolean registUser(JSONObject obj){
        String username = (String) obj.getString("username");
        if( userMapper.getUserByUsername(username) != null){
            return false;
        }
        User u = obj.toJavaObject(User.class);
        if(StringUtils.isAnyBlank(u.getUsername(), u.getPassword(), u.getSex(), u.getEmail())){
            return false;
        }
        Md5Hash m = new Md5Hash(u.getPassword(), u.getUsername(),1);
        u.setPassword(m.toString());
        userMapper.registUser(u);
        return true;
    }

    public ResponseEntity login(String username, String password){
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username,password);
        try {
            subject.login(token);
            Map<String,JSONObject> map = new HashMap<String, JSONObject>();
            User user = userMapper.getUserByUsername(username);
            JSONObject json = (JSONObject) JSON.toJSON(user);
            json.remove("password");
            map.put("user",json);
            return Response.ok(map);
        }catch (IncorrectCredentialsException e){
            return Response.unauth("用户名或密码不正确");
        }catch (UnknownAccountException e){
            return Response.unauth("用户名不存在");
        }
    }

    public User getUserByUsername(String username){
        return userMapper.getUserByUsername(username);
    }

    public void update(User user){
        userMapper.update(user);
    }

    public void updateHeadPort(String url, String username){
        userMapper.updateHeadPort(url, username);
    }

}
