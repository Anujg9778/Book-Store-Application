package com.example.greencommute.service.impl;

import com.example.greencommute.entity.Category;
import com.example.greencommute.respository.CategoryRepository;
import com.example.greencommute.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Optional<Category> findCategoryById(int theCategoryId) {
        return categoryRepository.findById(theCategoryId);
    }

    @Override
    public Category saveCategory(Category theCategory) {
        return categoryRepository.save(theCategory);
    }
}
