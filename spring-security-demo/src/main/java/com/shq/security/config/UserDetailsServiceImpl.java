package com.shq.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

//@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    PasswordEncoder passwordEncoder;

    /**
     * 获取用户逻辑
     * @param username the username identifying the user whose data is required.
     *
     * @return UserDeatails的实现User，包括加密后的密码
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 用户密码保存的是根据配置的加密算法加密后的格式
        String pwd = passwordEncoder.encode("shq2");
        return User.withUsername("shq2")
                .password(pwd)
                .authorities("admin")
                .build();
    }

}
