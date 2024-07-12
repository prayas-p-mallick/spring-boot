package org.paradox.week02_spring_mvc_emp_dept.dto;

import java.time.LocalDate;
import lombok.Builder;

@Builder
public record EmployeeDto(Long employeeId, String employeeFirstName, String employeeLastName, String gender,
                          Float salary, LocalDate dob, Byte age, String email) {

}
