package com.yyhn.vhr.controller.system.basic;

import com.yyhn.vhr.model.Department;
import com.yyhn.vhr.model.RespBean;
import com.yyhn.vhr.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/system/basic/department")
public class DepartmentController {
    @Autowired
    DepartmentService departmentService;

    @GetMapping("/")
    public List<Department> getDepartmentList(){
        return departmentService.getDepartmentList(-1);
    }
@PostMapping("/")
    public RespBean addDep(@RequestBody Department department){
    departmentService.addDep(department);
        if(department.getResult()>0){
    return RespBean.ok("添加成功",department);
        }
            RespBean.error("添加失败");

        return RespBean.error("添加失败");
    }

    @DeleteMapping("/{id}")
    public RespBean deleteDepartment(@PathVariable Integer id){
        Department department = new Department();
        department.setId(id);
        departmentService.deleteDepartment(department);
        if(department.getResult()==-2){
            return RespBean.error("该部门下还有子项目，删除失败");
        }else if(department.getResult()==-1){
            return RespBean.error("该部门下还有员工，删除失败");
        }else if(department.getResult()==1){
            return  RespBean.ok("删除成功");
        }
        return RespBean.error("删除失败");
    }
}
