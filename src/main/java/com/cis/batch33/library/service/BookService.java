package com.cis.batch33.library.service;

import com.cis.batch33.library.entity.LibraryBook;
import com.cis.batch33.library.model.Book;
import com.cis.batch33.library.repository.LibraryBookRepository;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;
import java.util.Optional;

@Service
public class BookService {
    @Autowired
    private LibraryBookRepository bookRepository;

    public LibraryBook createBook(LibraryBook books){

        // call the database
        Integer bookId = new Random().nextInt();
        books.setBookId(bookId);

        return bookRepository.save(books);
    }

    public LibraryBook getBook(Integer bookId) {

        Optional<LibraryBook> bookOptional =
                bookRepository.findById(bookId);
        return  bookOptional.orElse(new LibraryBook());

    }
    public LibraryBook updateBook(LibraryBook book,Integer bookId){

        // call the database
        book.setBookId(bookId);

        return bookRepository.save(book);
    }
    public void deleteBook(Integer bookId){
        bookRepository.deleteById(bookId);
    }
}

// relational databases ( SQL )
// tables and rows, foreign key, structured
// mysql, oracle, postgres, db2, H2 Microsoft Sql Server
// SQL - structured query language
// programming -
// create and manage tables - DDL - data definition language
// create and manage data within tables - DML - Data manipulation
// access control - DCL - data control language
// install mysql
// TOAD, mysql workbench - IDE

// non- relational databases ( No-SQL)
// unstructured
// document based - mongodb,
// key value database - redis, dynamodb,  cassandra
// graph database -


// schema
// tables
// rows and columns
// functions -
// stored procedures -

// user name and password


// JAVA to Database connectivity

//  JDBC package , java.sql.*

// Connection - url, username and password, mysql - driver
// PreparedStatement
// ResultSet
// CallabaleStatement

// ORM - object relational mapping
// JPA Repositories

// GET POST PUT DELETE - member and book
