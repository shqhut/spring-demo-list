package com.shq.demo.member.api;

import com.shq.demo.member.pojo.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "order-seata-demo", path = "/memberOrder")
public interface MemberOrderFeignClient {

    @RequestMapping(method = RequestMethod.GET, value = "/getMemberOrderList")
    Result getMemberOrderList();

    @RequestMapping(method = RequestMethod.POST, value = "/createMemberOrder")
    String createMemberOrder(@RequestParam("memberId") Integer memberId);

}
