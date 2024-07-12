package org.paradox.week02_spring_mvc_emp_dept.service.impl;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.paradox.week02_spring_mvc_emp_dept.dto.DepartmentDto;
import org.paradox.week02_spring_mvc_emp_dept.entity.DepartmentEntity;
import org.paradox.week02_spring_mvc_emp_dept.exception.ResourceNotFoundException;
import org.paradox.week02_spring_mvc_emp_dept.repository.DepartmentRepo;
import org.paradox.week02_spring_mvc_emp_dept.service.DepartmentService;
import org.paradox.week02_spring_mvc_emp_dept.util.Mapper;
import org.springframework.data.util.ReflectionUtils;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepo departmentRepo;
    private static final String resource = "Department";

    private DepartmentEntity departmentExists(Integer deptId) {

        return departmentRepo.findById(deptId).orElseThrow(() -> {
            final String msg = String.format("Department with ID - %s does not exist.", deptId);
            return new ResourceNotFoundException(resource, msg);
        });
    }

    @Override
    public List<DepartmentDto> fetchAllDepartments() {

        List<DepartmentEntity> entities = departmentRepo.findAll();
        if (entities.isEmpty()) {
            throw new ResourceNotFoundException(resource, "Department does not exists.");
        }
        return entities.stream().map(Mapper::convertEntityToDepartmentDto).toList();
    }

    @Override
    public DepartmentDto fetchDepartmentById(Integer deptId) {

        DepartmentEntity entity = departmentExists(deptId);
        return Mapper.convertEntityToDepartmentDto(entity);
    }

    @Override
    public DepartmentDto createDepartment(DepartmentDto departmentDto) {

        DepartmentEntity departmentEntity = Mapper.convertDtoToDepartmentEntity(departmentDto);
        return departmentRepo.findByDeptName(departmentEntity.getDeptName())
                             .map(Mapper::convertEntityToDepartmentDto)
                             .orElse(Mapper.convertEntityToDepartmentDto(departmentRepo.save(departmentEntity)));
    }

    @Override
    public DepartmentDto updateDepartment(Map<String, Object> updateRequest, Integer deptId) {

        DepartmentEntity entity = departmentExists(deptId);
        updateRequest.entrySet()
                     .stream()
                     .filter(entry -> !entry.getKey().equals("deptId"))
                     .filter(entry -> !entry.getKey().equals("totalStrength"))
                     .filter(entry -> !entry.getKey().equals("employees"))
                     .forEach(entry -> {
                         try {
                             Field entityField = ReflectionUtils.findRequiredField(DepartmentEntity.class,
                                                                                   entry.getKey()
                             );
                             entityField.setAccessible(true);
                             ReflectionUtils.setField(entityField, entity, entry.getValue());
                         } catch (IllegalArgumentException ignored) {
                             // Continue if the field is not found
                         }
                     });
        departmentRepo.save(entity);
        return Mapper.convertEntityToDepartmentDto(entity);
    }

    @Override
    public Boolean deleteDepartments(Integer deptId) {

        DepartmentEntity entity = departmentExists(deptId);
        departmentRepo.delete(entity);
        return true;
    }
}
