package com.example.greencommute.service;

import com.example.greencommute.entity.Book;

import java.util.List;
import java.util.Optional;

public interface BookService{

    List<Book> findAllBooks();

    Optional<Book> findBookById(int theBookId);

    void deleteBookById(int theBookId);

    Book saveBook (Book theBook);

    List<Book> getBooksByAuthor(String authorName);

    List<Book> getBooksByCategory(String categoryName);

}
