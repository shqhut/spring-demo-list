package com.shq.security.service.impl;

import com.shq.security.mapper.PermissionMapper;
import com.shq.security.pojo.Role;
import com.shq.security.pojo.User;
import com.shq.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private PermissionMapper permissionMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // $e0801$EQl2otdDdZLPCdVX8rK3g9s50I61K0vlVb9dBxbTPLqcnNXASQ6NOzRIuJeEdDsqNTj34aKtaBGAXE5CWOrKGQ==$5gQYYPQAQbrdNGc2c+AXr07CmfGdS6ntCunJ8dNNwH8=
        System.out.println("123456加密后的内容" + passwordEncoder.encode("123456"));
        boolean matches = passwordEncoder.matches("123456", "$e0801$Mr5PQFGX2gU+o86tLFKv926hvg1ca/2FLzBtqMJe3hAX9WrCxTwKZ9GbVnIBHZ6zmaxGkhAIvH4jh4hRp1V8Vg==$raUxhQBt3IoSfmUCfwWRfDHc6sr5BDsVhUxwWyqIQw8=");
        User user = permissionMapper.getByUserName(username);
        List<GrantedAuthority> authorities = new ArrayList<>();
        if (user != null) {
            List<Role> roleList = permissionMapper.getRoleByUserId(user.getId());
            roleList.forEach(role -> {
                if (role != null && !StringUtils.isEmpty(role.getEnname())) {
                    GrantedAuthority authority = new SimpleGrantedAuthority(role.getEnname());
                    authorities.add(authority);
                }
            });
            return new org.springframework.security.core.userdetails.User(
                    user.getUsername(),user.getPassword(),authorities);
        }else {
            throw new UsernameNotFoundException("用户名不存在");
        }


    }
}
