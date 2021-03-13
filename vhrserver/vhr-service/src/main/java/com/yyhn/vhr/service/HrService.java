package com.yyhn.vhr.service;

import com.yyhn.vhr.mapper.HrMapper;
import com.yyhn.vhr.mapper.HrRoleMapper;
import com.yyhn.vhr.model.Hr;

import com.yyhn.vhr.utils.HrsUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service("hrService")
public class HrService implements UserDetailsService {
    @Resource
    HrMapper hrMapper;

    @Resource
    HrRoleMapper hrRoleMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       Hr hr =  hrMapper.loadUserByUsername(username);
       if(hr==null){
           throw new UsernameNotFoundException("用户名不存在");
       }else {
           hr.setRoles(hrMapper.getHrRoleById(hr.getId()));
           return hr;
       }
    }

    public List<Hr> getAllHrs(String keywords) {
     return  hrMapper.getAllHrs(HrsUtils.getCurrentHr().getId(),keywords);
    }

    public Integer updateHr(Hr hr) {
        return hrMapper.updateByPrimaryKeySelective(hr);
    }

    public Integer deleteHrById(Integer id) {
        return hrMapper.deleteByPrimaryKey(id);
    }
@Transactional
    public boolean updateHrRole(Integer hrid, Integer[] rids) {
    hrRoleMapper.deleteByHrid(hrid);
        return hrRoleMapper.addRole(hrid,rids)==rids.length;
    }

    public List<Hr> getAllHrsExceptCurrentHr() {
        return hrMapper.getAllHrsExceptCurrentHr(HrsUtils.getCurrentHr().getId());
    }
}
