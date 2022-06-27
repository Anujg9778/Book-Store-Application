package com.example.greencommute.entity;

import com.example.bookstoreapplication.entity.Author;
import com.example.bookstoreapplication.entity.Category;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class CategoryTest {

    Category category = new Category(1,"Drama");

    @Test
    void categoryEntityTest(){

        assertEquals(1,category.getCategoryId());
        assertEquals("Paul Coehlo",category.getCategoryName());

        Category category1 = new Category();
        category1.setCategoryId(2);
        category1.setCategoryName("spring");

        assertEquals(2,category1.getCategoryId());
        assertEquals("spring",category1.getCategoryName());
    }

}