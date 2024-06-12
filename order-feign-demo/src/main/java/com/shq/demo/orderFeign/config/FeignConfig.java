package com.shq.demo.orderFeign.config;

import com.shq.demo.orderFeign.interceptor.FeignAuthRequestInterceptor;
import feign.Logger;
import org.springframework.context.annotation.Bean;

public class FeignConfig {

    @Bean
    public Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }

    @Bean
    public FeignAuthRequestInterceptor feignAuthRequestInterceptor() {
        return new FeignAuthRequestInterceptor();
    }

}
