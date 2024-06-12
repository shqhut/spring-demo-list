package com.shq.demo.orderFeign.config;

import com.shq.demo.orderFeign.interceptor.MiddleRequestInterceptor;
import org.springframework.context.annotation.Bean;

public class OpenApiFeignConfig {

    String access_key = "23oLGMKFQefMiPzQMs7JVCk4D1w";

    String secret_key = "MF6jNbi4pXo6fYzQFUUmoJDDL0o";

    @Bean
    public MiddleRequestInterceptor middleRequestInterceptor() {
        return new MiddleRequestInterceptor(access_key,secret_key);
    }

}
