package com.example.greencommute.service.impl;

import com.example.greencommute.entity.Book;
import com.example.greencommute.respository.BookRepository;
import com.example.greencommute.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl  implements BookService {

    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository){
        this.bookRepository = bookRepository;

    }

    @Override
    public List<Book> findAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Optional<Book> findBookById(int theBookId) {
        return bookRepository.findById(theBookId);
    }

    @Override
    public void deleteBookById(int theBookId) {
        bookRepository.deleteById(theBookId);
    }

    @Override
    public Book saveBook(Book theBook) {
        return bookRepository.save(theBook);
    }

    @Override
    public List<Book> getBooksByAuthor(String authorName) {
        return bookRepository.getBookByAuthor(authorName);
    }

    @Override
    public List<Book> getBooksByCategory(String categoryName) {
        return bookRepository.getBookByCategory(categoryName);
    }
}
