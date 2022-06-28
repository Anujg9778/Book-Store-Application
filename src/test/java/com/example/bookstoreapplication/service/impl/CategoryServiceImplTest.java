package com.example.bookstoreapplication.service.impl;

import com.example.bookstoreapplication.entity.Category;
import com.example.bookstoreapplication.respository.CategoryRepository;
import com.example.bookstoreapplication.service.CategoryService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
class CategoryServiceImplTest {

    @Mock
    CategoryRepository categoryRepository;

    private CategoryService categoryService;

    @BeforeEach
    void initUseCase(){
        categoryService = new CategoryServiceImpl(categoryRepository);
    }


    @Test
    void findCategory() {
        Optional<Category> category=Optional.of(new Category(1,"Educational"));

        Mockito.when(categoryRepository.findById(1)).thenReturn(category);
        Assertions.assertEquals(category, categoryService.findCategoryById(1));
        Mockito.verify(categoryRepository).findById(1);

    }

    @Test
    void saveCategory() {
        Category category=new Category(1,"Educational");

        Mockito.when(categoryRepository.save(category)).thenReturn(category);
        Assertions.assertEquals(category, categoryService.saveCategory(category));
        Mockito.verify(categoryRepository).save(category);

    }
}