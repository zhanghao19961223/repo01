package com.yyhn.vhr.controller.system.basic;

import com.yyhn.vhr.model.Hr;
import com.yyhn.vhr.model.RespBean;
import com.yyhn.vhr.model.Role;
import com.yyhn.vhr.service.HrService;
import com.yyhn.vhr.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/system/hr")
public class HrController {

    @Autowired
    HrService hrService;

    @Autowired
    RoleService roleService;

    @GetMapping("/")
    public List<Hr> getAllHrs(String keywords) {
        return hrService.getAllHrs(keywords);
    }


    @PutMapping("/")
    public RespBean updateHr(@RequestBody Hr hr) {
        if (hrService.updateHr(hr) > 0) {
            return RespBean.ok("修改成功！");
        } else {
            return RespBean.error("修改失败！");
        }
    }

    @DeleteMapping("/{id}")
    public RespBean deleteHrById(@PathVariable Integer id) {
        if (hrService.deleteHrById(id) > 0) {
            return RespBean.ok("删除成功！");
        } else {
            return RespBean.error("删除失败！");
        }
    }


    @GetMapping("/roles")
    public List<Role> getAllRole() {
        return roleService.getRoleList();
    }

    @PutMapping("/role")
    public RespBean updateHrRole(Integer hrid, Integer[] rids) {
        if (hrService.updateHrRole(hrid, rids)) {
            return RespBean.ok("更新成功");
        } else {
            RespBean.error("更新失败");
        }
        return null;
    }


}
