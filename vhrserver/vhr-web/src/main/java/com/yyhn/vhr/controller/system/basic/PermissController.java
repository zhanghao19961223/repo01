package com.yyhn.vhr.controller.system.basic;

import com.yyhn.vhr.model.Menu;
import com.yyhn.vhr.model.RespBean;
import com.yyhn.vhr.model.Role;
import com.yyhn.vhr.service.MenuService;
import com.yyhn.vhr.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/system/basic/permiss")
public class PermissController {
    @Autowired
    RoleService roleService;

    @Autowired
    MenuService menuService;

    @GetMapping("/")
    public List<Role> getRoleList() {
        return roleService.getRoleList();
    }

    @GetMapping("/meuns")
    public List<Menu> getMenuList() {
        return menuService.getMenuList();
    }

    @GetMapping("/mids/{rid}")//根据角色id获取所有资源id
    public List<Integer> getMidsByRid(@PathVariable Integer rid) {
        return menuService.getMidsByRid(rid);
    }

    @PutMapping("/")
    public RespBean updateMenuRole(Integer rid, Integer[] mids) {
        if (menuService.updateMenuRole(rid, mids)) {
            return RespBean.ok("更新成功");
        } else {
            return RespBean.error("更新失败");
        }
    }

    @PostMapping("/addRole")
    public RespBean addRole(@RequestBody Role role){
        if(roleService.addRole(role)>0){
            return RespBean.ok("新增成功");
        }else{
            return RespBean.error("新增失败");
        }
    }

    @DeleteMapping("/{rid}")
    public RespBean deleteRoleByRid(@PathVariable Integer rid){
        if(roleService.deleteRoleByRid(rid)>0){
            return RespBean.ok("删除成功");
        }else{
            return RespBean.error("删除失败");
        }
    }
}
