package com.shq.demo.orderSeata.mapper;

import com.shq.demo.orderSeata.pojo.MemberOrder;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MemberOrderMapper {

    List<MemberOrder> getMemberOrderList();

    Integer createMemberOrder(MemberOrder memberOrder);

}
