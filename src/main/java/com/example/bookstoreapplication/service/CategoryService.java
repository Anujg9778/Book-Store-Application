package com.example.bookstoreapplication.service;

import com.example.bookstoreapplication.entity.Category;

import java.util.Optional;

public interface CategoryService {

    Optional<Category> findCategoryById(int theCategoryId);

    Category saveCategory(Category theCategory);

}
