package com.example.bookstoreapplication.controller;

import com.example.bookstoreapplication.dto.BookDTO;
import com.example.bookstoreapplication.entity.Author;
import com.example.bookstoreapplication.entity.Book;
import com.example.bookstoreapplication.entity.Category;
import com.example.bookstoreapplication.exception.BookNotFoundException;
import com.example.bookstoreapplication.mapper.BookMapper;
import com.example.bookstoreapplication.service.AuthorService;
import com.example.bookstoreapplication.service.BookService;
import com.example.bookstoreapplication.service.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequestMapping("/books")
@Slf4j
@RestController
public class JobController {

    @Autowired
    private AuthorService authorService;

    @Autowired
    private BookService bookService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private BookMapper bookMapper;

    public void checkBookId(int bookId) throws BookNotFoundException {
        Optional<Book> theBook=bookService.findBookById(bookId);
        if(!theBook.isPresent()){
            throw new BookNotFoundException("Given Id does not exist");
        }
    }

    @PostMapping("/add-book")
    public BookDTO saveBook(@RequestBody BookDTO theBookDTO){

        Book theBook=bookMapper.convertToBook(theBookDTO);

        List<Author> authors = theBook.getAuthor();
        List<Category> categories = theBook.getCategory();

        if(authors!=null){
            for (Author author:authors) {
                authorService.saveAuthor(author);
            }
        }

        if(categories!=null){
            for (Category category:categories) {
                categoryService.saveCategory(category);
            }
        }

        return bookMapper.convertToBookDTO(bookService.saveBook(theBook));
    }

    @PutMapping("/")
    public BookDTO updateBook(@RequestBody BookDTO theBookDTO){

        Book theBook=bookMapper.convertToBook(theBookDTO);

        checkBookId(theBook.getBookId());

        return bookMapper.convertToBookDTO(bookService.saveBook(theBook));
    }

    @DeleteMapping("/{bookId}")
    public String deleteJobById(@PathVariable int bookId){

        checkBookId(bookId);

        bookService.deleteBookById(bookId);
        return " book with bookId :"+bookId+" deleted.";
    }

    @GetMapping("/")
    public List<BookDTO> findAllBooks(){

        return bookService.findAllBooks()
                .stream()
                .map(bookMapper::convertToBookDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{bookId}")
    public BookDTO findJobById(@PathVariable int bookId){

        Optional<Book> theBook=bookService.findBookById(bookId);
        if(!theBook.isPresent()){
            throw new BookNotFoundException("Given Id does not exist");
        }
        return bookMapper.convertToBookDTO(theBook.get());
    }

    @GetMapping("/location")
    public List<BookDTO> getBooksByAuthor(@RequestParam("author") String author){

        return bookService.getBooksByAuthor(author)
                .stream()
                .map(bookMapper::convertToBookDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/category")
    public List<BookDTO> getBookBySkills(@RequestParam("category") String category){

        return bookService.getBooksByCategory(category)
                .stream()
                .map(bookMapper::convertToBookDTO)
                .collect(Collectors.toList());
    }

}
