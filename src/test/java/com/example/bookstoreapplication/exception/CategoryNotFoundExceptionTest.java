package com.example.bookstoreapplication.exception;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CategoryNotFoundExceptionTest {

    CategoryNotFoundException exception = new CategoryNotFoundException("Category not found");

    @Test
    void categoryNotFoundExceptionTest(){
        assertEquals("Category not found",exception.getMessage());
    }
}