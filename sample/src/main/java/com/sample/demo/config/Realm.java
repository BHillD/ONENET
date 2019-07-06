package com.sample.demo.config;

import com.sample.demo.mapper.UserMapper;
import com.sample.demo.model.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * date: 2019/6/21
 * description: shiro 自定义Ream类
 */


public class Realm extends AuthorizingRealm {

    @Autowired
    private UserMapper userMapper;


    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
//        String username = (String)principals.getPrimaryPrincipal();
//        User user = userService.getUserByUsername(username);
//        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
//        info.addRole(user.getRole().getName());
//        return info;
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken args) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) args;
        String username = token.getUsername();
        User user = userMapper.getUserByUsername(username);
        if(user == null){
            return null;
        }
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(
                user.getUsername(),
                user.getPassword(),
                ByteSource.Util.bytes(user.getUsername()),
                this.getName()
        );
        SecurityUtils.getSubject().getSession().setAttribute("user", user);
        return info;
    }
}
