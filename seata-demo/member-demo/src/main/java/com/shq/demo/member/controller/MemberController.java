package com.shq.demo.member.controller;

import com.shq.demo.member.api.MemberOrderFeignClient;
import com.shq.demo.member.mapper.MemberMapper;
import com.shq.demo.member.pojo.Member;
import com.shq.demo.member.pojo.Result;
import com.shq.demo.member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/member")
public class MemberController {

    @Autowired
    MemberMapper memberMapper;

    @Autowired
    MemberService memberService;

    @RequestMapping(method = RequestMethod.GET, value = "/getMemberList")
    public Result<List<Member>> getMemberList() {
        List<Member> memberList = memberMapper.getMemberList();
        return Result.success(memberList);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/createMember")
    public Result<String> createMember(@RequestBody Member member) {
        Integer result = memberMapper.createMember(member);
        if (result > 0) {
            return Result.success("创建成功，会员id：" + member.getId());
        }else {
            return Result.error("创建失败, 会员姓名：" + member.getName());
        }
    }

    @RequestMapping(method = RequestMethod.POST, value = "/createMemberWithOrder")
    private Result<String> createMemberWithOrder(@RequestBody Member member) {
        Integer memberId = memberService.crateMemberWithOrder(member);
        return Result.success("创建成功，会员id：" + memberId);
    }

}
