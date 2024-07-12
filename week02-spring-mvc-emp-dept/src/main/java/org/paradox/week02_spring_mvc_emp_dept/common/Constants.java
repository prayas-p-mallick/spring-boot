package org.paradox.week02_spring_mvc_emp_dept.common;

public enum Constants {

    RESOURCE_DEPT("Department"),
    RESOURCE_EMP("Employee");

    public final String constant;

    Constants(String constant) {
        this.constant = constant;
    }
}
