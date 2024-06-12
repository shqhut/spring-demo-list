package com.shq.demo.sentinelCloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class SentinelCoudApplication {

    public static void main(String[] args) {
        SpringApplication.run(SentinelCoudApplication.class,args);
    }

}
