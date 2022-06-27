package com.example.bookstoreapplication.exception;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AuthorNotFoundExceptionTest {

    AuthorNotFoundException exception=new AuthorNotFoundException("Author not found");

    @Test
    void authorNotFoundExceptionTest(){
        assertEquals("Author not found",exception.getMessage());
    }
}