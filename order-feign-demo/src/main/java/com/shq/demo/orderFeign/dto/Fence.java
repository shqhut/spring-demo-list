package com.shq.demo.orderFeign.dto;

import lombok.Data;

@Data
public class Fence {

    private String fenceCode;

    private Integer radius;

    private Double longitude;

    private Double latitude;

    private Double[][] polygons;

    private String filterType;

    private String cityCode;

    private Integer segmentType;
}
