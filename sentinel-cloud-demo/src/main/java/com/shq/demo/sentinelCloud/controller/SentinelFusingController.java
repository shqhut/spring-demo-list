package com.shq.demo.sentinelCloud.controller;

import com.shq.demo.sentinelCloud.domain.Result;
import com.shq.demo.sentinelCloud.feign.StockFeign;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SentinelFusingController {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    StockFeign stockFeign;

    @RequestMapping(method = RequestMethod.GET, value = "/fusing/demo")
    public Result<String> testFusiong() {
        logger.info("sentinel熔断降级测试");
        // 远程调用stock-demo服务，并针对stock-demo提供的服务设置熔断降级策略
        return Result.success(stockFeign.reduceStock());
    }

}
