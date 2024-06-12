package com.shq.demo.orderRibbon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/order")
public class OrderTestController {

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping(method = RequestMethod.POST, value = "/orderTest")
    public String orderTest() {
//        ResponseEntity<String> exchange = restTemplate.exchange("http://localhost:8002/stock/reduceStock", HttpMethod.POST, null, String.class);
        ResponseEntity<String> exchange = restTemplate.exchange("http://stock-demo/stock/reduceStock", HttpMethod.POST, null, String.class);
        String result = exchange.getBody();
        System.out.println("调用库存服务，扣库存");
        return "库存服务结果："+ result +"下单成功！";
    }

}
