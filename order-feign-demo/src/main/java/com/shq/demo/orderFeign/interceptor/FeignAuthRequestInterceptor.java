package com.shq.demo.orderFeign.interceptor;

import feign.RequestInterceptor;
import feign.RequestTemplate;

import java.util.UUID;

public class FeignAuthRequestInterceptor implements RequestInterceptor {

    @Override
    public void apply(RequestTemplate template) {
        String access_tocke = UUID.randomUUID().toString();
        template.header("Authorization", access_tocke);
    }

}
