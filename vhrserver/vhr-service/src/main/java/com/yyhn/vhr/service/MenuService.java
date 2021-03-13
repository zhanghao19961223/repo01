package com.yyhn.vhr.service;

import com.yyhn.vhr.mapper.MenuMapper;
import com.yyhn.vhr.mapper.MenuRoleMapper;
import com.yyhn.vhr.model.Hr;
import com.yyhn.vhr.model.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service

public class MenuService {
    @Autowired
    MenuMapper menuMapper;

    @Autowired
    MenuRoleMapper menuRoleMapper;

    public List<Menu> getMenuByHrId() {
        return menuMapper.getMenusByHrId(((Hr) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId());
    }

    //    @Cacheable(value = "menus")
    public List<Menu> getAllMenusWithRole() {
        return menuMapper.getMenusWithRole();
    }

    public List<Menu> getMenuList() {
        return menuMapper.getMenuList();
    }

    public List<Integer> getMidsByRid(Integer rid) {
        return menuMapper.getMidsByRid(rid);
    }

    @Transactional
    public boolean updateMenuRole(Integer rid, Integer[] mids) {
        menuRoleMapper.deleteByRid(rid);
        if (mids!=null) {
            Integer result = menuRoleMapper.insertMenus(rid, mids);
            if (result > 0) {
                return true;
            } else {
                return false;
            }
        } else {
            return true;
        }
    }
}
