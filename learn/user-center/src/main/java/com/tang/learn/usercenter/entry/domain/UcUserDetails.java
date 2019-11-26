package com.tang.learn.usercenter.entry.domain;

import com.tang.learn.usercenter.entry.model.UcUser;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

/**
 * @author tang
 * @Classname UcUserDetails
 * @Description TODO
 * @Date 2019/11/23 15:34
 */
public class UcUserDetails implements UserDetails {
    private UcUser user;


    public UcUserDetails(UcUser user){
        this.user = user;
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        //返回当前用户的权限
        return Collections.singletonList(new SimpleGrantedAuthority("TEST"));
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return user.getStatus()==1;
    }

    public UcUser getUser() {
        return user;
    }
}
