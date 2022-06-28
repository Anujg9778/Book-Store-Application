package com.example.bookstoreapplication.service.impl;

import com.example.bookstoreapplication.entity.Author;
import com.example.bookstoreapplication.respository.AuthorRepository;
import com.example.bookstoreapplication.service.AuthorService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository authorRepository;
    public AuthorServiceImpl(AuthorRepository authorRepository){
        this.authorRepository = authorRepository;
    }

    @Override
    public Optional<Author> findAuthorById(int theAuthorId) {
        return authorRepository.findById(theAuthorId);
    }

    @Override
    public Author saveAuthor(Author theAuthor) {
        return authorRepository.save(theAuthor);
    }
}
