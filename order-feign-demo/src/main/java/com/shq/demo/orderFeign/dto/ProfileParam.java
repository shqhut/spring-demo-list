package com.shq.demo.orderFeign.dto;

import lombok.Data;

import java.util.List;

@Data
public class ProfileParam {

    private Integer profileType = 0;

    private String month;

    private Integer relation;

    private List<Fence> fences;
}
