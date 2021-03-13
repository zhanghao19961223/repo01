package com.yyhn.vhr.mapper;

import com.yyhn.vhr.model.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);

    List<Role> getRoleList();

    Integer addRole(Role role);

    Integer deleteRoleByRid(@Param("rid") Integer rid);
}