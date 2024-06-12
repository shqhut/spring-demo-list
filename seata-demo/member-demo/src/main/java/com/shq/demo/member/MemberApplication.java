package com.shq.demo.member;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@MapperScan("com.shq.demo.member.mapper") // 扫秒mapper接口，整合mybatis
@EnableFeignClients
public class MemberApplication {

    public static void main(String[] args) {
        SpringApplication.run(MemberApplication.class);
    }

}
