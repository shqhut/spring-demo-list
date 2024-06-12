package com.shq.demo.sentinelCloud.feign.sentinel;

import com.shq.demo.sentinelCloud.feign.StockFeign;
import org.springframework.stereotype.Component;

@Component
public class StockFeignFallBackService implements StockFeign {

    @Override
    public String reduceStock() {
        // 或者抛出异常
        return "stock-demo服务降级了！！！";
    }
}
