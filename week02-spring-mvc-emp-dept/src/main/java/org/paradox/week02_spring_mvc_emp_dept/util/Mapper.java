package org.paradox.week02_spring_mvc_emp_dept.util;

import org.paradox.week02_spring_mvc_emp_dept.dto.DepartmentDto;
import org.paradox.week02_spring_mvc_emp_dept.entity.DepartmentEntity;

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

        return new DepartmentEntity(departmentDto.departmentName().toLowerCase(), departmentDto.departmentHead().toLowerCase());
    }
}
