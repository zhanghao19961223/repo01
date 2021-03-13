package com.yyhn.vhr.mapper;

import com.yyhn.vhr.model.MenuRole;
import org.apache.ibatis.annotations.Param;

public interface MenuRoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MenuRole record);

    int insertSelective(MenuRole record);

    MenuRole selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MenuRole record);

    int updateByPrimaryKey(MenuRole record);

    void deleteByRid(@Param("rid") Integer rid);

    Integer insertMenus(@Param("rid") Integer rid, @Param("mids") Integer[] mids);
}