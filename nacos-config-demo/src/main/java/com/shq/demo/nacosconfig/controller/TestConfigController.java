package com.shq.demo.nacosconfig.controller;

import com.alibaba.nacos.api.config.annotation.NacosValue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class TestConfigController {

    @Value("${user.age}")
    public String age;

    @RequestMapping(method = RequestMethod.GET,value = "/testValue")
    public String testValue() {
        return "获取到的age为：" + age;
    }

}
