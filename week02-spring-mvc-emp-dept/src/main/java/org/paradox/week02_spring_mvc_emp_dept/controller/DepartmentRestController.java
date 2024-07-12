package org.paradox.week02_spring_mvc_emp_dept.controller;

import java.util.List;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.paradox.week02_spring_mvc_emp_dept.dto.DepartmentDto;
import org.paradox.week02_spring_mvc_emp_dept.service.DepartmentService;
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
@RequestMapping(value = "/departments")
public class DepartmentRestController {

    private final DepartmentService departmentService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<DepartmentDto>> fetchAllDepartments() {

        return ResponseEntity.ok(departmentService.fetchAllDepartments());
    }

    @GetMapping(value = "/{departmentId}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<DepartmentDto> fetchDepartmentById(@PathVariable("departmentId") Integer deptId) {

        return ResponseEntity.ok(departmentService.fetchDepartmentById(deptId));
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<DepartmentDto> createDepartment(@RequestBody DepartmentDto departmentDto) {

        return new ResponseEntity<>(departmentService.createDepartment(departmentDto), HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/{departmentId}")
    ResponseEntity<Boolean> deleteDepartment(@PathVariable("departmentId") Integer deptId) {

        return ResponseEntity.ok(departmentService.deleteDepartment(deptId));
    }

    @PutMapping(value = "/{departmentId}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<DepartmentDto> updateDepartment(@RequestBody Map<String, Object> updateRequest,
            @PathVariable("departmentId") Integer deptId) {

        return ResponseEntity.ok(departmentService.updateDepartment(updateRequest, deptId));
    }
}
