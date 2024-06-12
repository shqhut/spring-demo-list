package com.shq.demo.orderFeign.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "stock-demo", path = "/stock")
public interface StockFeign {

    @RequestMapping(method = RequestMethod.POST, value = "/reduceStock")
    String reduceStock();

}
