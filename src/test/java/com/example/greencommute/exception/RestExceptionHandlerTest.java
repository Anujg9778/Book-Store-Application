package com.example.greencommute.exception;

import com.example.greencommute.respository.JobRepository;
import com.example.greencommute.service.JobService;
import com.example.greencommute.service.impl.JobServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class RestExceptionHandlerTest {

    JobService jobService;

    @Mock
    JobRepository jobRepository;

    @BeforeEach
    void setUp(){

        jobService=new JobServiceImpl(jobRepository);
    }
    @Mock
    RestExceptionHandler restExceptionHandler;

    @Test
    void exceptionHandler() {
        ErrorResponse error=new ErrorResponse("Job with given Id does not exist",12345, HttpStatus.NOT_FOUND.value());
        JobNotFoundException jobNotFoundException=new JobNotFoundException("Job with given Id does not exist");
        ResponseEntity<ErrorResponse> badRequest=new ResponseEntity<>(error,HttpStatus.NOT_FOUND);

        Mockito.when(restExceptionHandler.exceptionHandler(jobNotFoundException)).thenReturn(badRequest);
        restExceptionHandler.exceptionHandler(jobNotFoundException);
        Mockito.verify(restExceptionHandler).exceptionHandler(jobNotFoundException);

    }
}

