package com.yyhn.vhr.controller.emp;

import com.yyhn.vhr.model.*;
import com.yyhn.vhr.service.*;

import com.yyhn.vhr.util.POIUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/emp/basic")
public class EmpBasicController {


    @Autowired
    EmployeeService employeeService;

    @Autowired
    NationService nationService;

    @Autowired
    PoliticsstatusService politicsstatusService;//政治面貌

    @Autowired
    JobService jobService;//职称
    @Autowired
    PositionService positionService;//职位

    @Autowired
    DepartmentService departmentService;//部门

    @GetMapping("/")
    public RespPageBean getEmployeeByPage(@RequestParam(defaultValue = "1") Integer page,
                                          @RequestParam(defaultValue = "10") Integer size,
                                          Employee employee, Date[] beginDateScope) {
        System.out.println(employee);
        System.out.println(beginDateScope);
        return employeeService.getEmployeeByPage(page, size, employee, beginDateScope);
    }

    @PostMapping("/")
    public RespBean addEmp(@RequestBody Employee employee) {
        if (employeeService.addEmp(employee) > 0) {
            return RespBean.ok("添加成功!");
        }
        return RespBean.error("添加失败!");
    }

    //加载民族
    @GetMapping("/getAllNation")
    public List<Nation> getAllNation() {
        return nationService.getAllNation();
    }


    @GetMapping("/getAllPoliticsstatus")
    public List<Politicsstatus> getAllPoliticsstatus() {

        return politicsstatusService.getAllPoliticsstatus();
    }

    @GetMapping("/getAllJObLevel")
    public List<JObLevel> getAllJObLevel() {
        return jobService.getJobLevelList();
    }

    @GetMapping("/getAllPosition")
    public List<Position> getAllPosition() {
        return positionService.getPositionList();
    }

    @GetMapping("/maxWorkID")
    public RespBean maxWorkID() {
        RespBean respBean = RespBean.build().setStatus(200)
                .setObj(String.format("%08d", employeeService.maxWorkID() + 1));
        return respBean;
    }

    @GetMapping("/getAllDepartment")
    public List<Department> getAllDepartment() {

        List<Department> departmentList = departmentService.getDepartmentList(-1);
        return departmentList;
    }

    @DeleteMapping("/deleteEmpByEid/{id}")
    public RespBean deleteEmpByEid(@PathVariable Integer id) {

        Integer result = employeeService.deleteById(id);
        if (result > 0) {
            return RespBean.ok("删除成功");
        }
        return RespBean.error("删除失败");

    }

    @PutMapping("/")
    public RespBean updateEmp(@RequestBody Employee employee) {
        Integer result = employeeService.updateEmp(employee);
        if (result > 0) {
            return RespBean.ok("更新成功");
        }
        return RespBean.error("更新失败");
    }

    @GetMapping("/export")
    public ResponseEntity<byte[]> exportData() {
        List<Employee> list = (List<Employee>) employeeService.getEmployeeByPage(null, null, new Employee(), null).getData();

        return POIUtils.employee2Excel(list);
    }


    @PostMapping("/import")
    public RespBean importData(MultipartFile file) throws IOException {
    List list8= nationService.getAllNation();
    List list2= politicsstatusService.getAllPoliticsstatus();
         List<Department> allDepartmentsWithOutChildren = departmentService.getAllDepartmentsWithOutChildren();
        List list4= positionService.getPositionList();
    List list5= jobService.getJobLevelList();
        List<Employee> list = POIUtils.excel2Employee(file, nationService.getAllNation(), politicsstatusService.getAllPoliticsstatus(),  departmentService.getAllDepartmentsWithOutChildren(), positionService.getPositionList(), jobService.getJobLevelList());
        if (employeeService.addEmps(list) == list.size()) {
            return RespBean.ok("上传成功");
        }
        return RespBean.error("上传失败");
    }
}
