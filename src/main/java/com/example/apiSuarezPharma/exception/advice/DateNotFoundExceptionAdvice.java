package com.example.apiSuarezPharma.exception.advice;

import com.example.apiSuarezPharma.exception.DateNotFoundException;
import com.example.apiSuarezPharma.exception.DoctorNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class DateNotFoundExceptionAdvice {
    @ResponseBody
    @ExceptionHandler(DateNotFoundException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public String handleDateNotFoundException(DateNotFoundException ex){ return ex.getMessage(); }
}
