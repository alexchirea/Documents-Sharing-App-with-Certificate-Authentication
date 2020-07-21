package com.alexchirea.ilvermory.controller;

import com.alexchirea.ilvermory.exception.EntityNotFound;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionAdvice {

    @ExceptionHandler(value = EntityNotFound.class)
    public String handleEntityNotFoundException(EntityNotFound e) {
        return "not-found";
    }

}
