package com.example.bookstoreapplication.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CategoryExceptionHandler {

    @ExceptionHandler(CategoryNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleException(CategoryNotFoundException exc){

        ErrorResponse error = new ErrorResponse();
        error.setMessage(exc.getMessage());
        error.setTimeStamp(System.currentTimeMillis());
        error.setStatus(HttpStatus.NOT_FOUND.value());

        return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleException(Exception exc){

        ErrorResponse error = new ErrorResponse();

        error.setMessage(exc.getMessage());
        error.setTimeStamp(System.currentTimeMillis());
        error.setStatus(HttpStatus.BAD_REQUEST.value());

        return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
    }

}
