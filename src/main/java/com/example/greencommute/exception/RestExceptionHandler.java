package com.example.greencommute.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(JobNotFoundException.class)
    public ResponseEntity<JobNotFoundError> jobNotFoundExceptionHandler(JobNotFoundException exception){

        JobNotFoundError error=new JobNotFoundError("Job with given Id does not exist",System.currentTimeMillis(), HttpStatus.NOT_FOUND.value());

        return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<JobNotFoundError> exceptionHandler(Exception exception){

        JobNotFoundError error=new JobNotFoundError("Job with given Id does not exist",System.currentTimeMillis(), HttpStatus.BAD_REQUEST.value());

        return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
    }


}
