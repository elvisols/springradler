package com.springapp.springradler.api;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;
import javax.validation.ConstraintViolationException;

import com.springapp.springradler.api.dto.ErrorDTO;
import com.springapp.springradler.api.dto.ErrorsDTO;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestControllerAdvice
public class ApiExceptionHandler {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(EntityNotFoundException.class)
    public void handleNotFound(EntityNotFoundException e) {

        log.debug("Entity not found.", e);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ConstraintViolationException.class) // occurs during Hibernate Validation
    public ErrorsDTO handleConstraintViolations(ConstraintViolationException e) {

        final List<ErrorDTO> errors = e
                .getConstraintViolations().stream().map(v -> ErrorDTO.builder().message(v.getMessage())
                        .path(v.getPropertyPath().toString()).value(v.getInvalidValue()).build())
                .collect(Collectors.toList());

        return new ErrorsDTO(errors);
    }

}
