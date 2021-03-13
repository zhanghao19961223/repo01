package com.yyhn.vhr.service;

import com.yyhn.vhr.mapper.DepartmentMapper;
import com.yyhn.vhr.model.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("departmentService")
public class DepartmentService {
    @Autowired
    DepartmentMapper departmentMapper;

    public List<Department> getDepartmentList(Integer pid) {
        return departmentMapper.getDepartmentList(pid);
    }

    public void addDep(Department department) {
        department.setEnabled(true);
        departmentMapper.addDep(department);
    }

    public List<Department> getAllDepartmentsWithOutChildren() {
        return departmentMapper.getAllDepartmentsWithOutChildren();
    }

    public void deleteDepartment(Department department) {
        departmentMapper.deleteDepartment(department);
    }
}
