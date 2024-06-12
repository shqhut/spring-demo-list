package com.shq.security.config;

import com.shq.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;

@Configuration
public class WebSecurityConfig2 extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserService userService;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new SCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        String password = passwordEncoder().encode("123456");
        auth
                // 使用基于内存的inMemoryUserDetailsManager
                .inMemoryAuthentication()
                // 配置用户
                .withUser("shq2").password(password).roles("admin")
                .and().withUser("shq3").password(password).roles("user");
        // 设置UserDetailsService实现类
//        auth.userDetailsService(userService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 自定义表单登录
        http.formLogin()
                .loginPage("/login.html")
                .loginProcessingUrl("/user/login")
//                .defaultSuccessUrl("/main.html")
                .successForwardUrl("");
        // 授权
        http.authorizeRequests()
                .antMatchers("/login.html","/user/login")
                .permitAll().anyRequest().authenticated()
                .and()
                .csrf().disable();
    }

}
