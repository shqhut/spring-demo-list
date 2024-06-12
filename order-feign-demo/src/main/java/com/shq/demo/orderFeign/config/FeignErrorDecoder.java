package com.shq.demo.orderFeign.config;

import feign.FeignException;
import feign.Response;

class FeignErrorDecoder implements feign.codec.ErrorDecoder {
    @Override
    public Exception decode(String methodKey, Response response) {
        return new MidPlatformApiException()
            .setFeignException(FeignException.errorStatus(methodKey, response))
            .setMethod(methodKey)
            .setCode(response.status());
    }
}
