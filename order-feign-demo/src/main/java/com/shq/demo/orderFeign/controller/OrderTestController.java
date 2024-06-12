package com.shq.demo.orderFeign.controller;

import com.alibaba.nacos.common.utils.JacksonUtils;
import com.azul.crs.json.JSONStaticSerializer;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.shq.demo.orderFeign.config.HttpSign;
import com.shq.demo.orderFeign.dto.Fence;
import com.shq.demo.orderFeign.dto.ProfileParam;
import com.shq.demo.orderFeign.feign.OpenApiFeign;
import com.shq.demo.orderFeign.feign.ProductFeign;
import com.shq.demo.orderFeign.feign.StockFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderTestController {

    @Autowired
    StockFeign stockFeign;

    @Autowired
    ProductFeign productFeign;

    @Autowired
    OpenApiFeign openApiFeign;

    @RequestMapping(method = RequestMethod.POST, value = "/orderTest/{productId}")
    public String orderTest(@PathVariable String productId) {
        String productResult = productFeign.getProduct(productId);
        String reduceStock = stockFeign.reduceStock();
        System.out.println("调用库存服务，扣库存");
        return "商品服务结果：" + productResult + "库存服务结果："+ reduceStock +"下单成功！";
    }


    @RequestMapping(method = RequestMethod.POST, value = "/openapiTest")
    public String openapiTest() throws IOException {
        ProfileParam param = new ProfileParam();
        param.setMonth("2023-08");
        param.setRelation(1);
        Fence fence = new Fence();
        fence.setRadius(500);
        fence.setLongitude(104.080536);
        fence.setLatitude(30.652211);
        fence.setFenceCode("circle");
        fence.setFilterType("all");
        fence.setSegmentType(1);
        List<Fence> fences = new ArrayList<>();
        fences.add(fence);
        param.setFences(fences);
//        String result = openApiFeign.crowdProfile(param);
        HttpSign httpSign = new HttpSign("mtRSS3vYIfll2yRxeSwi3UYD5B8", "V9nu6USwFdBqvyDDdgYr8lJlVAI");
        String constent = JacksonUtils.toJson(param);
        httpSign.sendRequest("https://lbi-api.newayz.com/openapi/v1/crowdProfile", "POST", constent);
        System.out.println("result");
        return "result";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/openapiTest2")
    public String openapiTest2() throws IOException {
//        String result = openApiFeign.queryAllGridHeatNonSubscription("310115","2022121900");
//        System.out.println(result);
        HttpSign httpSign = new HttpSign("23oLGMKFQefMiPzQMs7JVCk4D1w", "MF6jNbi4pXo6fYzQFUUmoJDDL0o");
        httpSign.sendRequest("https://lbi-api.newayz.com/openapi/v1/gridHeat/queryAllGridHeatNonSubscription?disCode=310115&queryDate=2022121900", "GET", "");
        return "result";
    }

}
