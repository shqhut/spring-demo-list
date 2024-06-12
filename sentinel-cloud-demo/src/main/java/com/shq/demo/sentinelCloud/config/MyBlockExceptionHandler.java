package com.shq.demo.sentinelCloud.config;

import com.alibaba.csp.sentinel.adapter.spring.webmvc.callback.BlockExceptionHandler;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.authority.AuthorityException;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeException;
import com.alibaba.csp.sentinel.slots.block.flow.FlowException;
import com.alibaba.csp.sentinel.slots.block.flow.param.ParamFlowException;
import com.alibaba.csp.sentinel.slots.system.SystemBlockException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.shq.demo.sentinelCloud.domain.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * BlockException异常统一处理
 */
@Component
public class MyBlockExceptionHandler implements BlockExceptionHandler {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, BlockException e) throws Exception {

        logger.error("BlockExceptionHandler BlockException==========" + e.getRule());

        Result result = null;

        if (e instanceof FlowException) {
            result = Result.error("100", "服务被限流了");
        } else if (e instanceof DegradeException) {
            result = Result.error("101", "服务降级了");

        } else if (e instanceof ParamFlowException) {
            result = Result.error("102", "热点参数限流了");

        } else if (e instanceof SystemBlockException) {
            result = Result.error("103", "触发系统保护规则了");

        } else if (e instanceof AuthorityException) {
            result = Result.error("104", "授权规则不通过");
        }

        // 返回JSON数据
        response.setStatus(500);
        response.setCharacterEncoding("utf-8");
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        new ObjectMapper().writeValue(response.getWriter(), result);
    }

}
