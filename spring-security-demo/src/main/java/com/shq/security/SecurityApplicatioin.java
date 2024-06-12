package com.shq.security;

import com.shq.security.config.ConfigTest;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@MapperScan("com.shq.security.mapper") // 扫秒mapper接口，整合mybatis
@EnableConfigurationProperties({ConfigTest.class})
public class SecurityApplicatioin {

    public static void main(String[] args) {
        SpringApplication.run(SecurityApplicatioin.class);
    }
}
