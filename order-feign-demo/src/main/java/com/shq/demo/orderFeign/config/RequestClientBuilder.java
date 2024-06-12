package com.shq.demo.orderFeign.config;

import com.shq.demo.orderFeign.interceptor.MiddleRequestInterceptor;
import feign.Feign;
import feign.Logger;
import feign.Request;
import feign.Retryer;
import feign.slf4j.Slf4jLogger;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.client.HttpClientBuilder;

public interface RequestClientBuilder {

    static <T> T build(String host, String accessKey, String secretKey, Class<T> clazz) {
        return Feign.builder()
                .encoder(new JacksonEncoder())
                .decoder(new JacksonDecoder())
                .errorDecoder(new FeignErrorDecoder())
                .options(new Request.Options(3000, 120000))
                .retryer(new Retryer.Default(5000, 5000, 1))
                .logger(new Slf4jLogger(clazz))
                .logLevel(Logger.Level.FULL)
                .requestInterceptor(new MiddleRequestInterceptor(accessKey, secretKey))
                .target(clazz, host);
    }

}
