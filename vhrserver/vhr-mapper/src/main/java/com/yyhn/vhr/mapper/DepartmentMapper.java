package com.yyhn.vhr.mapper;

import com.yyhn.vhr.model.Department;

import java.util.List;

public interface DepartmentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Department record);

    int insertSelective(Department record);

    Department selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Department record);

    int updateByPrimaryKey(Department record);

    public List<Department> getDepartmentList(Integer pid);

    public  void addDep(Department department);

    List<Department> getAllDepartmentsWithOutChildren();

    void deleteDepartment(Department department);
}