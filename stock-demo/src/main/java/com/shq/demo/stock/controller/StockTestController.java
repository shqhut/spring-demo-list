package com.shq.demo.stock.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stock")
public class StockTestController {

    @Value("${server.port}")
    String port;

    @RequestMapping(method = RequestMethod.POST, value = "/reduceStock")
    public String reduceStock() {
        return port + "扣件库存成功！";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/headerTest")
    public String headerTest(@RequestHeader("X-Request-Color") String color) {
        return "成功获取X-Request-Color值：" + color;
    }
}
