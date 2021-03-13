package com.yyhn.vhr.service;

import com.yyhn.vhr.mapper.RoleMapper;
import com.yyhn.vhr.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("roleService")
public class RoleService {
    @Autowired
    RoleMapper roleMapper;

    public List<Role> getRoleList() {
        return roleMapper.getRoleList();
    }

    public Integer addRole(Role role) {
        if(!role.getName().startsWith("ROLE_")){
            role.setName("ROLE_"+role.getName());
        }
        return roleMapper.addRole(role);
    }

    public Integer deleteRoleByRid(Integer rid) {
        return roleMapper.deleteRoleByRid(rid);
    }
}
