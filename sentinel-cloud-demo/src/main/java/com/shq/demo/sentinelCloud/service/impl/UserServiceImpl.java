package com.shq.demo.sentinelCloud.service.impl;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.shq.demo.sentinelCloud.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    @SentinelResource(value = "getUser", blockHandler = "blockHandlerForGetUser")
    public String getUser(String userName) {
        return "这是用户信息，用户名为：" + userName;
    }

    public String blockHandlerForGetUser(String userName, BlockException e) {
        logger.error("获取用户限流了，异常信息："+e);
        return "获取用户信息限流处理，查询用户名：" + userName;
    }

}
