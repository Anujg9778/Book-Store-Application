package com.example.greencommute.service;

import com.example.greencommute.entity.Category;

import java.util.Optional;

public interface CategoryService {

    Optional<Category> findCategoryById(int theCategoryId);

    Category saveCategory(Category theCategory);

}
