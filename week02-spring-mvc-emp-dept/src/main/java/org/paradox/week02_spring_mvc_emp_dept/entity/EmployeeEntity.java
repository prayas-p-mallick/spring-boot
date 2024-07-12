package org.paradox.week02_spring_mvc_emp_dept.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import java.time.LocalDate;
import java.time.Period;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "employees")
public class EmployeeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "empIdGenerator")
    @SequenceGenerator(name = "empIdGenerator", sequenceName = "empIdSeqGenerator", allocationSize = 2, initialValue = 303)
    private Long empId;

    @Column(nullable = false, unique = true, length = 90)
    private String email;

    @Column(nullable = false, length = 30)
    private String firstName;

    @Column(nullable = false, length = 40)
    private String lastName;

    @Column(nullable = false, length = 6)
    private String gender;

    @Column(nullable = false)
    private Byte age;

    private Float salary;

    private Boolean isActive = true;

    private Boolean isPermanent = true;

    private LocalDate dob;

    public EmployeeEntity(String firstName, String lastName, String gender, Float salary, LocalDate dob, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.salary = salary;
        this.dob = dob;
        this.email = email;
        this.age = (byte) Period.between(dob, LocalDate.now()).getYears();
    }
}
