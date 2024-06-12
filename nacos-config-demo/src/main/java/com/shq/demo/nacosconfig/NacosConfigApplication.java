package com.shq.demo.nacosconfig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class NacosConfigApplication {

    public static void main(String[] args) throws InterruptedException {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(NacosConfigApplication.class, args);
//        while (true) {
//            String userName = applicationContext.getEnvironment().getProperty("user.name");
//            String userAge = applicationContext.getEnvironment().getProperty("user.age");
//            String common_config = applicationContext.getEnvironment().getProperty("common.config");
//            String db_user = applicationContext.getEnvironment().getProperty("db.user");
//            System.out.println("user name :"+userName+"; age: "+userAge+"; common config: "+common_config+"; db user: "+db_user);
//            Thread.sleep(1000);
//        }

    }
}
