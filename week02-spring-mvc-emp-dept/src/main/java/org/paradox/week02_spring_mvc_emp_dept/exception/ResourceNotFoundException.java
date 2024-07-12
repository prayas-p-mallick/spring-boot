package org.paradox.week02_spring_mvc_emp_dept.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class ResourceNotFoundException extends RuntimeException {

    private final String resource;
    private final String message;
}
