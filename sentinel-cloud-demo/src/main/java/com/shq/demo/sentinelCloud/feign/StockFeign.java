package com.shq.demo.sentinelCloud.feign;

import com.shq.demo.sentinelCloud.feign.sentinel.StockFeignFallBackService;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Service
@FeignClient(value = "stock-demo", path = "/stock", fallback = StockFeignFallBackService.class)
public interface StockFeign {

    @RequestMapping(method = RequestMethod.POST, value = "/reduceStock")
    String reduceStock();

}
