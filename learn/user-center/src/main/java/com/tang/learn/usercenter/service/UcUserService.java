package com.tang.learn.usercenter.service;

import com.tang.learn.usercenter.entry.model.UcUser;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * @Classname UcUserService
 * @Description TODO
 * @Date 2019/11/23 15:24
 * @author tang
 */
public interface UcUserService extends IService<UcUser>{
    /**
     * 通过用户名获取用户信息
     */
    public UcUser getUserInfoByUsername(String username);
    /**
     * 获取用户信息
     */
    public UserDetails loadUserByUsername(String username);
    /**
     * 登录后获取token
     */
    String login(String username, String password);
    /**
     * 注册用户
     */
    Boolean register(String username, String password,String telephone);
    /**
     * 刷新token
     */
    String refreshToken(String token);
}
