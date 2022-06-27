package com.example.greencommute.exception;

import com.example.bookstoreapplication.exception.AuthorNotFoundException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AuthorNotFoundExceptionTest {

    AuthorNotFoundException exception=new AuthorNotFoundException("Author not found");

    @Test
    void authorNotFoundExceptionTest(){
        assertEquals("Author not found",exception.getMessage());
    }
}