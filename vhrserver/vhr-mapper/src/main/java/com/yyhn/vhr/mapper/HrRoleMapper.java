package com.yyhn.vhr.mapper;

import com.yyhn.vhr.model.Hr;
import com.yyhn.vhr.model.HrRole;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface HrRoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(HrRole record);

    int insertSelective(HrRole record);

    HrRole selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(HrRole record);

    int updateByPrimaryKey(HrRole record);

    Integer addRole(@Param("hrid") Integer hrid, @Param("rids") Integer[] rids);
    void deleteByHrid(Integer hrid);

}