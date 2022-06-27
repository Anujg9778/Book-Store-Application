package com.example.greencommute.respository;


import com.example.greencommute.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface BookRepository  extends JpaRepository<Book,Integer> {

    @Query("SELECT name FROM Book b WHERE b.name = :name")
    Book findBookByName(@Param("name") String name);

    @Query(value="select * from books,author,book_author where books.book_id=book_author.author_id and author.author_id = book_author.author_id and author.author_name=:name",
            nativeQuery=true)
    List<Book> getBookByAuthor(@Param("name") String authorName);

    @Query(value="select * from books,category,book_category where books.book_id=book_category.category_id and category.category_id = book_category.category_id and category.category_name=:name",
            nativeQuery=true)
    List<Book> getBookByCategory(@Param("name") String categoryName);
}

