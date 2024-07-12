package org.paradox.week02_spring_mvc_emp_dept.dto;

import lombok.Builder;

@Builder
public record DepartmentDto(Integer departmentID, String departmentName, String departmentHead, Long totalDepartmentStrength) {
}
