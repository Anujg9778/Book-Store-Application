package com.example.bookstoreapplication.exception;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookNotFoundExceptionTest {

    @Test
    void exceptionTest(){
        Throwable throwable=new Throwable();

        BookNotFoundException exception=new BookNotFoundException("Book Id Not Found");
        assertEquals("Book Id Not Found",exception.getMessage());

        BookNotFoundException exception1=new BookNotFoundException(throwable);
        assertEquals(throwable,exception1.getCause());

        BookNotFoundException exception2=new BookNotFoundException("Book Id Not Found",throwable);
        assertEquals(throwable,exception2.getCause());
        assertEquals("Book Id Not Found",exception2.getMessage());
    }

}