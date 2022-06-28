package com.example.bookstoreapplication.respository;


import com.example.bookstoreapplication.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface BookRepository  extends JpaRepository<Book,Integer> {

    @Query(value="select * from books,author,book_author where books.id=book_author.book_id and author.id = book_author.author_id and author.name=:name",
            nativeQuery=true)
    List<Book> getBookByAuthor(@Param("name") String authorName);

    @Query(value="select * from books,category,book_category where books.id=book_category.book_id and category.id = book_category.category_id and category.name=:name",
            nativeQuery=true)
    List<Book> getBookByCategory(@Param("name") String categoryName);
}

