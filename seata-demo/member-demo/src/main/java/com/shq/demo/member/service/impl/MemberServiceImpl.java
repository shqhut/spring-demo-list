package com.shq.demo.member.service.impl;

import com.shq.demo.member.api.MemberOrderFeignClient;
import com.shq.demo.member.mapper.MemberMapper;
import com.shq.demo.member.pojo.Member;
import com.shq.demo.member.pojo.Result;
import com.shq.demo.member.service.MemberService;
import io.seata.spring.annotation.GlobalTransactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MemberServiceImpl implements MemberService {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    MemberMapper memberMapper;

    @Autowired
    MemberOrderFeignClient memberOrderFeignClient;

    @GlobalTransactional
    @Override
    public Integer crateMemberWithOrder(Member member) {
        Integer result = memberMapper.createMember(member);
        if (result > 0) {
            String memberOrderResult = memberOrderFeignClient.createMemberOrder(member.getId());
            logger.info("会员{}调用会员订单接口接口：{}",member.getId(),memberOrderResult);
        }
        // 模拟发生异常
        int i = 1/0;
        return member.getId();
    }
}
