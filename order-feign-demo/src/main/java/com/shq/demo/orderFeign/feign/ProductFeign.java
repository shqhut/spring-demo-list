package com.shq.demo.orderFeign.feign;

import com.shq.demo.orderFeign.config.FeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "product-demo", path = "/product", configuration = FeignConfig.class)
public interface ProductFeign {

    @RequestMapping(method = RequestMethod.GET, value = "/getProduct/{productId}")
    String getProduct(@PathVariable("productId") String productId);

}
