package com.yyhn.vhr.service;

import com.yyhn.vhr.mapper.NationMapper;
import com.yyhn.vhr.model.Nation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NationService {

    @Autowired
    NationMapper nationMapper;
    public List<Nation> getAllNation() {
        return nationMapper.getAllNation();
    }
}
