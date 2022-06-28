package com.example.bookstoreapplication.service;

import com.example.bookstoreapplication.entity.Author;

import java.util.Optional;

public interface AuthorService {

    Optional<Author> findAuthorById(int theAuthorId);

    Author saveAuthor(Author theAuthor);

}
