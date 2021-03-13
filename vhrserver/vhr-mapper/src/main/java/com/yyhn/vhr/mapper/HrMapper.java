package com.yyhn.vhr.mapper;

import com.yyhn.vhr.model.Hr;
import com.yyhn.vhr.model.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface HrMapper {

    Hr loadUserByUsername(String username);

    int deleteByPrimaryKey(Integer id);

    int insert(Hr record);

    int insertSelective(Hr record);

    Hr selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Hr record);

    int updateByPrimaryKey(Hr record);

    List<Role> getHrRoleById(Integer id);

    List<Hr> getAllHrs(@Param("hrid") Integer hrid,@Param("keywords") String keywords);


    List<Hr> getAllHrsExceptCurrentHr(Integer id);
}