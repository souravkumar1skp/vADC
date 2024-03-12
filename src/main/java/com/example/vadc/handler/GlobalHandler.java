package com.example.vadc.handler;

import com.example.vadc.error.CustomError;
import com.example.vadc.exception.WrongPageNumberRequested;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalHandler {
    @ExceptionHandler(WrongPageNumberRequested.class)
    public ResponseEntity<CustomError> handleWrongPageNumberRequested(Exception ex)
    {
        CustomError error= new CustomError();
        error.setErr_code(404);
        error.setError_description((ex.getMessage()));
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
}
