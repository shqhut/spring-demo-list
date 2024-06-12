package com.shq.demo.orderFeign.config;

import feign.FeignException;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
public class MidPlatformApiException extends RuntimeException {
    private FeignException feignException;
    private int code;
    private String method;
}
