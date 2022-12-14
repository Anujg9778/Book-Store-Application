package com.example.bookstoreapplication.exception;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import static org.junit.jupiter.api.Assertions.*;

class BookNotFoundErrorTest {

    @Test
    void bookNotFoundErrorTest(){

        ErrorResponse error=new ErrorResponse("cannot find Id",16549457, HttpStatus.NOT_FOUND.value());

        assertEquals("cannot find Id",error.getMessage());
        assertEquals(16549457,error.getTimeStamp());
        assertEquals(HttpStatus.NOT_FOUND.value(),error.getStatus());

        ErrorResponse error1=new ErrorResponse();
        error1.setMessage("cannot find Id");
        error1.setTimeStamp(16549457);
        error1.setStatus(HttpStatus.NOT_FOUND.value());

        assertEquals("cannot find Id",error1.getMessage());
        assertEquals(16549457,error1.getTimeStamp());
        assertEquals(HttpStatus.NOT_FOUND.value(),error1.getStatus());
    }

}