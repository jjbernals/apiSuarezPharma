package com.example.apiSuarezPharma.exception.advice;

import com.example.apiSuarezPharma.exception.DoctorNotFoundException;
import com.example.apiSuarezPharma.exception.UserFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class DoctorNotFoundExceptionAdvice {
    @ResponseBody
    @ExceptionHandler(DoctorNotFoundException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public String handleDoctorFoundException(DoctorNotFoundException ex){ return ex.getMessage(); }
}
