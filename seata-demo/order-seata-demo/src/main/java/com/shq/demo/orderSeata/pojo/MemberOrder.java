package com.shq.demo.orderSeata.pojo;

import lombok.Data;

@Data
public class MemberOrder {

    private Integer id;

    private Integer memberId;

    private String orderNum;

}
