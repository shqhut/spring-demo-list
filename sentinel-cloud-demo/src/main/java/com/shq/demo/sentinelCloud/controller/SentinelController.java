package com.shq.demo.sentinelCloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.shq.demo.sentinelCloud.domain.Result;
import com.shq.demo.sentinelCloud.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sentinel")
public class SentinelController {

    @Autowired
    UserService userService;

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(method = RequestMethod.GET, value = "/dashboardTest")
    @SentinelResource(value = "dashboard test")
    public Result dashboardTest() {
        return Result.success();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getOrder")
    public Result<String> getOrder() {
        logger.info("sentinel关联限流测试，调用getOrder接口");
        return Result.success("订单数据列表.....");
    }

    @RequestMapping(method = RequestMethod.POST, value = "/addOrder")
    public Result<String> addOrder() {
        logger.info("sentinel关联限流测试，调用addOrder接口");
        return Result.success("添加订单成功！！！");
    }

    @RequestMapping(method = RequestMethod.GET, value = "/orderTest1")
    public Result<String> orderTest1() {
        logger.info("sentinel关联限流测试，调用orderTest1接口");
        String userInfo = userService.getUser("orderTest1用户");
        return Result.success(userInfo);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/orderTest2")
    public Result<String> orderTest2() {
        logger.info("sentinel关联限流测试，调用orderTest2接口");
        String userInfo = userService.getUser("orderTest2用户");
        return Result.success(userInfo);
    }

}
