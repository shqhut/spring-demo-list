package com.shq.demo.product.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductTestController {

    @Value("${server.port}")
    String port;

    @RequestMapping(method = RequestMethod.GET, value = "/getProduct/{productId}")
    public String getProduct(@PathVariable("productId") String productId) {
        return port + "获取商品库存接口，商品：" + productId;
    }
}
