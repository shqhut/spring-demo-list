package com.shq.security.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class Role {

    private Long id;

    private Long parent_id;

    private String name;

    private String enname;

    private String description;

    private Date created;

    private Date updated;
}
