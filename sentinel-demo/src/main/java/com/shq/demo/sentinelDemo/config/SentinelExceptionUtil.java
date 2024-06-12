package com.shq.demo.sentinelDemo.config;

import com.alibaba.csp.sentinel.slots.block.BlockException;

public class SentinelExceptionUtil {

    public static String fallback(String name, BlockException ex) {
        return "服务被降级了";
    }

    public static String handleException(String name, BlockException ex) {
        return "服务被限流了";
    }
}
