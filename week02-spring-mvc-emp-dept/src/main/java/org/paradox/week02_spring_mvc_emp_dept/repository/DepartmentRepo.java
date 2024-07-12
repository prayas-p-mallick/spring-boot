package org.paradox.week02_spring_mvc_emp_dept.repository;

import java.util.Optional;
import org.paradox.week02_spring_mvc_emp_dept.entity.DepartmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepo extends JpaRepository<DepartmentEntity, Integer> {

    Optional<DepartmentEntity> findByDeptName(String deptName);
}
