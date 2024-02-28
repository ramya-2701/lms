package com.cis.batch33.library.controller;
import com.cis.batch33.library.entity.LibraryBook;
import com.cis.batch33.library.entity.LibraryMember;
import com.cis.batch33.library.model.Book;
import com.cis.batch33.library.service.BookService;
import com.cis.batch33.library.service.MemberService;
import org.apache.tomcat.jni.Library;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping("/{bookId}")
    public LibraryBook getBook(@PathVariable Integer bookId){
        return bookService.getBook(bookId);
    }

    // create a member
    @PostMapping
    public LibraryBook createBook(@RequestBody LibraryBook books){
        return bookService.createBook(books);
    }

    @PutMapping("/{bookId}")
    public LibraryBook updateBook(@RequestBody LibraryBook books,@PathVariable Integer bookId){
        return bookService.updateBook(books,bookId);
    }
    @DeleteMapping("/{bookId}")
    public void deleteBook(@PathVariable Integer bookId){
        bookService.deleteBook(bookId);
    }

}
