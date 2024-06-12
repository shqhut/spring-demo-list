package com.shq.demo.member.mapper;

import com.shq.demo.member.pojo.Member;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MemberMapper {

    List<Member> getMemberList();

    Integer createMember(Member member);

}
