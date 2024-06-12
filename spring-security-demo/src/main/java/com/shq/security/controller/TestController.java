package com.shq.security.controller;

import com.shq.security.config.ConfigTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    ConfigTest configTest;

    @RequestMapping(value = "/test/helloSecurity", method = RequestMethod.GET)
    public String hello() {
        System.out.println(configTest.getUser());
        return "hello security！";
    }

    @RequestMapping(value = "/test/going", method = RequestMethod.GET)
    public String going() {
        System.out.println(configTest.getUser());
        return "going！！！";
    }

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index() {
        String username = getUsername();
        return username + "已经登录成功！！！";
    }

    private String getUsername() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!authentication.isAuthenticated()) {
            return null;
        }
        Object principal = authentication.getPrincipal();
        String username = null;
        if (principal instanceof UserDetails) {
            username = ((UserDetails) principal).getUsername();
        }else {
            username = principal.toString();
        }
        return username;
    }


}
