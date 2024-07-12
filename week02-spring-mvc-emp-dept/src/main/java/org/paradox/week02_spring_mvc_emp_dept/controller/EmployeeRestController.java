package org.paradox.week02_spring_mvc_emp_dept.controller;

import java.util.List;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.paradox.week02_spring_mvc_emp_dept.dto.EmployeeDto;
import org.paradox.week02_spring_mvc_emp_dept.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/employees")
public class EmployeeRestController {

    private final EmployeeService employeeService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<EmployeeDto>> fetchAllEmployees() {

        return ResponseEntity.ok(employeeService.fetchAllEmployees());
    }

    @GetMapping(value = "/{employeeId}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<EmployeeDto> fetchDepartmentById(@PathVariable("employeeId") Long empId) {

        return ResponseEntity.ok(employeeService.fetchEmployeeById(empId));
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto) {

        return new ResponseEntity<>(employeeService.createEmployee(employeeDto), HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/{employeeId}")
    ResponseEntity<Boolean> deleteEmployee(@PathVariable("employeeId") Long empId) {

        return ResponseEntity.ok(employeeService.deleteEmployee(empId));
    }

    @PutMapping(value = "/{employeeId}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<EmployeeDto> updateEmployee(@RequestBody Map<String, Object> updateRequest,
            @PathVariable("employeeId") Long empId) {

        return ResponseEntity.ok(employeeService.updateEmployee(updateRequest, empId));
    }
}
