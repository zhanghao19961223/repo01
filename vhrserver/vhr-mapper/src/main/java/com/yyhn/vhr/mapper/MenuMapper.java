package com.yyhn.vhr.mapper;

import com.yyhn.vhr.model.Menu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MenuMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Menu record);

    int insertSelective(Menu record);

    Menu selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Menu record);

    int updateByPrimaryKey(Menu record);

    List<Menu> getMenusByHrId(Integer hrid);

    List<Menu> getMenusWithRole();

    List<Menu> getMenuList();

    List<Integer> getMidsByRid(@Param("rid") Integer rid);
}