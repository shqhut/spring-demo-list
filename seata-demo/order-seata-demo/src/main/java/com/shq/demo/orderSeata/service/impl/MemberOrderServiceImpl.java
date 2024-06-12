package com.shq.demo.orderSeata.service.impl;

import com.shq.demo.orderSeata.mapper.MemberOrderMapper;
import com.shq.demo.orderSeata.pojo.MemberOrder;
import com.shq.demo.orderSeata.service.MemberOrderService;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberOrderServiceImpl implements MemberOrderService {

    @Autowired
    MemberOrderMapper memberOrderMapper;

    @GlobalTransactional
    @Override
    public Integer createMemberOrder(MemberOrder memberOrder) {
        return memberOrderMapper.createMemberOrder(memberOrder);
    }

}
