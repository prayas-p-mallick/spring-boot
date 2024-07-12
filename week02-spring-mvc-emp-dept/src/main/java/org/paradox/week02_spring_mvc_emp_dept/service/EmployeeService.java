package org.paradox.week02_spring_mvc_emp_dept.service;

import java.util.List;
import java.util.Map;
import org.paradox.week02_spring_mvc_emp_dept.dto.EmployeeDto;

public interface EmployeeService {

    List<EmployeeDto> fetchAllEmployees();

    EmployeeDto fetchEmployeeById(Long empId);

    EmployeeDto createEmployee(EmployeeDto employeeDto);

    EmployeeDto updateEmployee(Map<String, Object> updateRequest, Long empId);

    Boolean deleteEmployee(Long empId);
}
