package com.example.greencommute.exception;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JobNotFoundExceptionTest {

    @Test
    void exceptionTest(){
        Throwable throwable=new Throwable();

        JobNotFoundException exception=new JobNotFoundException("Job Id Not Found");
        assertEquals("Job Id Not Found",exception.getMessage());

        JobNotFoundException exception1=new JobNotFoundException(throwable);
        assertEquals(throwable,exception1.getCause());

        JobNotFoundException exception2=new JobNotFoundException("Job Id Not Found",throwable);
        assertEquals(throwable,exception2.getCause());
        assertEquals("Job Id Not Found",exception2.getMessage());
    }

}