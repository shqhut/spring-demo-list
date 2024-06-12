package com.shq.demo.orderSeata.controller;

import com.shq.demo.orderSeata.mapper.MemberOrderMapper;
import com.shq.demo.orderSeata.pojo.MemberOrder;
import com.shq.demo.orderSeata.pojo.Result;
import com.shq.demo.orderSeata.service.MemberOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/memberOrder")
public class MemberOrderController {

    @Autowired
    MemberOrderMapper memberOrderMapper;

    @Autowired
    MemberOrderService memberOrderService;

    @RequestMapping(method = RequestMethod.GET, value = "/getMemberOrderList")
    public Result<List<MemberOrder>> getMemberOrderList() {
        List<MemberOrder> memberOrderList = memberOrderMapper.getMemberOrderList();
        return Result.success(memberOrderList);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/createMemberOrder")
    public String createMemberOrder(@RequestParam("memberId") Integer memberId) {
        // 生成订单编码
        MemberOrder memberOrder = new MemberOrder();
        String orderNum = UUID.randomUUID().toString();
        memberOrder.setOrderNum(orderNum);
        memberOrder.setMemberId(memberId);
        Integer result = memberOrderService.createMemberOrder(memberOrder);
        if (result > 0) {
            return "会员订单创建成功，订单编码是：" + orderNum;
        }else {
            return "创建失败，会员id：" + memberOrder.getMemberId();
        }
    }
}
