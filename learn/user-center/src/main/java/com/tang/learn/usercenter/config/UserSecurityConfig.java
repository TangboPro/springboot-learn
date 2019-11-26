package com.tang.learn.usercenter.config;

import com.tang.learn.securitycenter.config.SecurityConfig;
import com.tang.learn.usercenter.service.UcUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * @author tang
 * @Classname UserSecurityConfig
 * @Description TODO
 * @Date 2019/11/23 15:00
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled=true)
public class UserSecurityConfig  extends SecurityConfig {
    @Autowired
    private UcUserService userService;
    @Override
    @Bean
    public UserDetailsService userDetailsService() {
        //获取登录用户信息
        return username -> userService.loadUserByUsername(username);
    }
}
