package com.yyhn.vhr.mapper;

import com.yyhn.vhr.model.Position;
import com.yyhn.vhr.model.RespBean;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PositionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Position record);

    int insertSelective(Position record);

    Position selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Position record);

    int updateByPrimaryKey(Position record);

    List<Position> getPositionList();

    Integer addPosition(Position position);

    Integer deletePositionsByIds(@Param("ids") Integer[] ids);
}