package com.yangle.security;


import com.yangle.entity.User;
import com.yangle.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

/**
 * Created by yangle on 2017/10/9.
 */
@Component
public class SnailUserDetailsService implements UserDetailsService {
    @Autowired
    private IUserService userService;
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
User user=userService.getUserInfo(userName);
        if(user==null){
            return null;
        }
CustUserDetails custUserDetails=new CustUserDetails(user.getUsername(),user.getPassword(),"");
        return custUserDetails;
    }
}