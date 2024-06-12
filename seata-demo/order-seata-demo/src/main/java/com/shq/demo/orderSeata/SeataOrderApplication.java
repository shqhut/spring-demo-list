package com.shq.demo.orderSeata;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.shq.demo.orderSeata.mapper")
public class SeataOrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(SeataOrderApplication.class);
    }

}
