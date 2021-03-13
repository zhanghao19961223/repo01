package com.yyhn.vhr.service;

import com.yyhn.vhr.mapper.PositionMapper;
import com.yyhn.vhr.model.Position;
import com.yyhn.vhr.model.RespBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service("positionService")
public class PositionService {
    @Autowired
    PositionMapper positionMapper;

    public List<Position> getPositionList() {
        return positionMapper.getPositionList();
    }

    public Integer addPosition(Position position) {
        position.setEnabled(true);
        position.setCreateDate(new Date());
        return positionMapper.insertSelective(position);
    }

    public Integer updatePosition(Position position) {
       /* if(!position.getName().startsWith("ROLE_")){
            position.setName("ROLE_"+position.getName());
        }*/
        return positionMapper.updateByPrimaryKey(position);
    }

    public Integer deletePosition(Integer id) {
        return  positionMapper.deleteByPrimaryKey(id);
    }

    public Integer deletePositionsByIds(Integer[] ids){
        return positionMapper.deletePositionsByIds(ids);
    }
}
