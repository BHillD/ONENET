package com.sample.demo.config;

import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;

/**
 * date: 2019/6/21
 * description: SHRIO安全框架配置类
 */


@Configuration
public class ShrioConfig {

    @Bean("credentialsMatcher")
    public HashedCredentialsMatcher hashedCredentialsMatcher() {
        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
        hashedCredentialsMatcher.setHashAlgorithmName("md5");
        hashedCredentialsMatcher.setHashIterations(1);
        return hashedCredentialsMatcher;
    }

    @Bean("realm")
    public Realm getRealm(@Qualifier("credentialsMatcher") HashedCredentialsMatcher credentialsMatcher) {
        Realm realm = new Realm();
        realm.setCredentialsMatcher(credentialsMatcher);
        return realm;
    }

    @Bean("defaultSecurityManager")
    public DefaultWebSecurityManager getSecurityManager(@Qualifier("realm") Realm realm){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(realm);
        return securityManager;
    }

    @Bean("shiroFilter")
    public ShiroFilterFactoryBean filterFactoryBean(@Qualifier("defaultSecurityManager") DefaultWebSecurityManager securityManager){
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        LinkedHashMap<String, String> map = new LinkedHashMap<>();
//        map.put("/auth/*","anon");
//        map.put("/**","authc");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(map);
        return shiroFilterFactoryBean;
    }
}
