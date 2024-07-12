package org.paradox.week02_spring_mvc_emp_dept.advice;

import org.paradox.week02_spring_mvc_emp_dept.exception.ResourceNotFoundException;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

@SuppressWarnings("ALL")
@RestControllerAdvice
class GlobalRestControllerAdvice implements ResponseBodyAdvice<Object> {

    @ExceptionHandler(ResourceNotFoundException.class)
    ResponseEntity<ApiError> handlesResourceNotFoundException(final ResourceNotFoundException e) {

        ApiError error = new ApiError(e.getResource(), e.getMessage());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {

        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType,
            Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request,
            ServerHttpResponse response) {

        if (body instanceof ApiError) {
            return new ApiResponse(null, body);
        }
        return new ApiResponse(body, null);
    }
}
