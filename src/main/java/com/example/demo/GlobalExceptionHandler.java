package com.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    @ResponseStatus(HttpStatus.REQUEST_HEADER_FIELDS_TOO_LARGE)
    public String ERDAExeption(Exception e) {
        return "ないよ(^Д^)";
    }

}
