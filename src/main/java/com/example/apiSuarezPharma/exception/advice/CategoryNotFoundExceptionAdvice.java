package com.example.apiSuarezPharma.exception.advice;

import com.example.apiSuarezPharma.exception.CategoryNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class CategoryNotFoundExceptionAdvice {
    @ResponseBody
    @ExceptionHandler(CategoryNotFoundException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public String handleCategoryNotFoundException(CategoryNotFoundException ex){ return ex.getMessage(); }
}
