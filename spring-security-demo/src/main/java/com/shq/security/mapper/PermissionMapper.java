package com.shq.security.mapper;

import com.shq.security.pojo.Role;
import com.shq.security.pojo.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PermissionMapper {

    User getByUserName(String name);

    List<Role> getRoleByUserId(Long userId);

}
