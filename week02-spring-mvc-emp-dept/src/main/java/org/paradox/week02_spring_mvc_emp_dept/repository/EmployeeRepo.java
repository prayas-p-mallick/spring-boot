package org.paradox.week02_spring_mvc_emp_dept.repository;

import java.util.Optional;
import org.paradox.week02_spring_mvc_emp_dept.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepo extends JpaRepository<EmployeeEntity, Long> {

    Optional<EmployeeEntity> findByEmail(String email);
}
