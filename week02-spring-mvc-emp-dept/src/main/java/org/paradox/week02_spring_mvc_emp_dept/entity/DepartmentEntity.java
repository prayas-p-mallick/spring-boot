package org.paradox.week02_spring_mvc_emp_dept.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class DepartmentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "deptIdGenerator")
    @SequenceGenerator(name = "deptIdGenerator", sequenceName = "deptIdSeqGenerator", initialValue = 13, allocationSize = 3)
    private Integer deptId;

    @Column(nullable = false, length = 40, unique = true)
    private String deptName;

    @Column(nullable = false, length = 70)
    private String deptHead;

    private Long totalStrength = 0L;

    public DepartmentEntity(String deptName, String deptHead) {

        this.deptName = deptName;
        this.deptHead = deptHead;
    }
}
