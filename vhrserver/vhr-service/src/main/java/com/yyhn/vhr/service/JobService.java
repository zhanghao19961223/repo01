package com.yyhn.vhr.service;

import com.yyhn.vhr.mapper.JObLevelMapper;
import com.yyhn.vhr.model.JObLevel;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service("jobService")
public class JobService {
    @Autowired
    JObLevelMapper jObLevelMapper;

    public List<JObLevel> getJobLevelList() {
        return jObLevelMapper.getJobLevelList();
    }

    public Integer addJob(JObLevel jObLevel) {
        jObLevel.setCreateDate(new Date());
        jObLevel.setEnabled(true);
        return jObLevelMapper.insert(jObLevel);
    }

    public Integer delJob(Integer id) {
       return jObLevelMapper.deleteByPrimaryKey(id);
    }

    public Integer updateJob(JObLevel jObLevel) {
        jObLevel.setCreateDate(new Date());
        return jObLevelMapper.updateByPrimaryKeySelective(jObLevel);
    }
}
