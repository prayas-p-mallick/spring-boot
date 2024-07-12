package org.paradox.week02_spring_mvc_emp_dept.util;

import org.paradox.week02_spring_mvc_emp_dept.dto.DepartmentDto;
import org.paradox.week02_spring_mvc_emp_dept.dto.EmployeeDto;
import org.paradox.week02_spring_mvc_emp_dept.entity.DepartmentEntity;
import org.paradox.week02_spring_mvc_emp_dept.entity.EmployeeEntity;

public class Mapper {

    public static DepartmentDto convertEntityToDepartmentDto(DepartmentEntity departmentEntity) {

        return DepartmentDto.builder()
                            .departmentID(departmentEntity.getDeptId())
                            .departmentName(departmentEntity.getDeptName())
                            .departmentHead(departmentEntity.getDeptHead())
                            .totalDepartmentStrength(departmentEntity.getTotalStrength())
                            .build();
    }

    public static DepartmentEntity convertDtoToDepartmentEntity(DepartmentDto departmentDto) {

        return new DepartmentEntity(departmentDto.departmentName().toLowerCase(),
                                    departmentDto.departmentHead().toLowerCase()
        );
    }

    public static EmployeeDto convertEntityToEmployeeDto(EmployeeEntity employeeEntity) {

        return EmployeeDto.builder()
                          .employeeId(employeeEntity.getEmpId())
                          .employeeFirstName(employeeEntity.getFirstName())
                          .employeeLastName(employeeEntity.getLastName())
                          .gender(employeeEntity.getGender())
                          .salary(employeeEntity.getSalary())
                          .dob(employeeEntity.getDob())
                          .age(employeeEntity.getAge())
                          .email(employeeEntity.getEmail())
                          .build();
    }

    public static EmployeeEntity convertDtoToEmployeeEntity(EmployeeDto employeeDto) {

        return new EmployeeEntity(employeeDto.employeeFirstName().toLowerCase(),
                                  employeeDto.employeeLastName().toLowerCase(),
                                  employeeDto.gender().toLowerCase(),
                                  employeeDto.salary(),
                                  employeeDto.dob(),
                                  employeeDto.email().toLowerCase()
        );
    }
}
