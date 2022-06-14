package com.example.greencommute.exception;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserNotFoundExceptionTest {

    UserNotFoundException exception=new UserNotFoundException("User not found");

    @Test
    void userNotFoundExceptionTest(){
        assertEquals("User not found",exception.getMessage());
    }
}