package org.paradox.week02_spring_mvc_emp_dept.service;

import java.util.List;
import java.util.Map;
import org.paradox.week02_spring_mvc_emp_dept.dto.DepartmentDto;

public interface DepartmentService {

    List<DepartmentDto> fetchAllDepartments();

    DepartmentDto fetchDepartmentById(Integer deptId);

    DepartmentDto createDepartment(DepartmentDto departmentDto);

    DepartmentDto updateDepartment(Map<String, Object> updateRequest, Integer deptId);

    Boolean deleteDepartments(Integer deptId);
}
