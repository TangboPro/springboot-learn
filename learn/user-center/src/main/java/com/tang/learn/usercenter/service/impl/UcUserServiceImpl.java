package com.tang.learn.usercenter.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.tang.learn.securitycenter.util.JwtTokenUtil;
import com.tang.learn.usercenter.entry.domain.UcUserDetails;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tang.learn.usercenter.dao.UcUserMapper;
import com.tang.learn.usercenter.entry.model.UcUser;
import com.tang.learn.usercenter.service.UcUserService;

import java.util.Date;

/**
 * @Classname UcUserServiceImpl
 * @Description TODO
 * @Date 2019/11/23 15:24
 * @author tang
 */
@Service
public class UcUserServiceImpl extends ServiceImpl<UcUserMapper, UcUser> implements UcUserService{
    private static final Logger LOGGER = LoggerFactory.getLogger(UcUserServiceImpl.class);
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private UcUserMapper ucUserMapper;
    @Override
    public UcUser getUserInfoByUsername(String username) {
        Wrapper<UcUser> queryByUserNameWrapper=new QueryWrapper<UcUser>().lambda()
                .eq(UcUser::getUsername,username);
        UcUser user= this.getOne(queryByUserNameWrapper);
        if(user!=null){
            return user;
        }
        return null;
    }
    @Override
    public UserDetails loadUserByUsername(String username) {
        UcUser user = getUserInfoByUsername(username);
        if(user!=null){
            return new UcUserDetails(user);
        }
        throw new UsernameNotFoundException("用户名或密码错误");
    }

    @Override
    public String login(String username, String password) {
        String token = null;
        //密码需要客户端加密后传递
        try {
            UserDetails userDetails = loadUserByUsername(username);
            if(!passwordEncoder.matches(password,userDetails.getPassword())){
                throw new BadCredentialsException("密码不正确");
            }
            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);
            token = jwtTokenUtil.generateToken(userDetails);
        } catch (AuthenticationException e) {
            LOGGER.warn("登录异常:{}", e.getMessage());
        }
        return token;
    }

    @Override
    public Boolean register(String username, String password, String telephone) {
        //查询是否已有该用户
        Wrapper<UcUser> queryByUserNameAndPhoneWrapper=new QueryWrapper<UcUser>().lambda()
                .eq(UcUser::getUsername,username)
                .eq(UcUser::getPhone,telephone);
        UcUser user= this.getOne(queryByUserNameAndPhoneWrapper);
        if (user != null) {
            //全局异常处理
            return false;
        }
        //没有该用户进行添加操作
        UcUser ucUser = new UcUser();
        ucUser.setUsername(username);
        ucUser.setPhone(telephone);
        ucUser.setPassword(passwordEncoder.encode(password));
        ucUser.setCreateTime(new Date());
        ucUser.setStatus(1);
        return ucUserMapper.insert(ucUser)>0;
    }

    @Override
    public String refreshToken(String token) {
        return jwtTokenUtil.refreshHeadToken(token);
    }
}
