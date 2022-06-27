package com.example.greencommute.service;

import com.example.greencommute.entity.Author;

import java.util.List;
import java.util.Optional;

public interface AuthorService {

    Optional<Author> findAuthorById(int theAuthorId);

    Author saveAuthor(Author theAuthor);

}
