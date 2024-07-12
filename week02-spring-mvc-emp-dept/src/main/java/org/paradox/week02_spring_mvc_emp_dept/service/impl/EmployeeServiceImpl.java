package org.paradox.week02_spring_mvc_emp_dept.service.impl;

import static org.paradox.week02_spring_mvc_emp_dept.common.Constants.RESOURCE_EMP;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.paradox.week02_spring_mvc_emp_dept.dto.EmployeeDto;
import org.paradox.week02_spring_mvc_emp_dept.entity.EmployeeEntity;
import org.paradox.week02_spring_mvc_emp_dept.exception.ResourceNotFoundException;
import org.paradox.week02_spring_mvc_emp_dept.repository.EmployeeRepo;
import org.paradox.week02_spring_mvc_emp_dept.service.EmployeeService;
import org.paradox.week02_spring_mvc_emp_dept.util.Mapper;
import org.springframework.data.util.ReflectionUtils;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepo employeeRepo;

    private EmployeeEntity employeeExists(Long empId) {

        return employeeRepo.findById(empId).orElseThrow(() -> {
            final String msg = String.format("Employee with ID - %s does not exist.", empId);
            return new ResourceNotFoundException(RESOURCE_EMP.constant, msg);
        });
    }

    @Override
    public List<EmployeeDto> fetchAllEmployees() {

        List<EmployeeEntity> entities = employeeRepo.findAll();
        if (entities.isEmpty()) {
            throw new ResourceNotFoundException(RESOURCE_EMP.constant, "Employees does not exist.");
        }
        return entities.stream().map(Mapper::convertEntityToEmployeeDto).toList();
    }

    @Override
    public EmployeeDto fetchEmployeeById(Long empId) {

        EmployeeEntity employeeEntity = employeeExists(empId);
        return Mapper.convertEntityToEmployeeDto(employeeEntity);
    }

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {

        EmployeeEntity entity = Mapper.convertDtoToEmployeeEntity(employeeDto);
        return employeeRepo.findByEmail(entity.getEmail())
                           .map(Mapper::convertEntityToEmployeeDto)
                           .orElse(Mapper.convertEntityToEmployeeDto(employeeRepo.save(entity)));
    }


    @Override
    public EmployeeDto updateEmployee(Map<String, Object> updateRequest, Long empId) {

        EmployeeEntity entity = employeeExists(empId);
        updateRequest.entrySet()
                     .stream()
                     .filter(entry -> !entry.getKey().equals("empId"))
                     .filter(entry -> !entry.getKey().equals("age"))
                     .forEach(entry -> {
                         try {
                             Field entityField = ReflectionUtils.findRequiredField(EmployeeEntity.class,
                                                                                   entry.getKey()
                             );
                             entityField.setAccessible(true);
                             ReflectionUtils.setField(entityField, entity, entry.getValue());
                         } catch (IllegalArgumentException ignored) {
                             // Continue if the field is not found
                         }
                     });
        employeeRepo.save(entity);
        return Mapper.convertEntityToEmployeeDto(entity);
    }

    @Override
    public Boolean deleteEmployee(Long empId) {

        EmployeeEntity entity = employeeExists(empId);
        employeeRepo.delete(entity);
        return true;
    }
}
