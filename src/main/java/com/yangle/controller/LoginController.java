package com.yangle.controller;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;

/**
 * Created by yangle on 2017/9/24.
 */
@Controller
public class LoginController {
    @RequestMapping("/login")
public String login(Model model, HttpServletRequest request, String error, String logout) {
    if (logout != null) {
        model.addAttribute("msg", "你已经成功退出");
    }
    model.addAttribute("ctx",request.getContextPath());

    return "login";
}
@RequestMapping("/home")
    public String home(){
    UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext()
            .getAuthentication()
            .getPrincipal();
    String userName=userDetails.getUsername();
    String passwd=userDetails.getPassword();
    Collection<? extends GrantedAuthority> authorities = userDetails.getAuthorities();
    return "index";
}
}
