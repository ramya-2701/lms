package com.cis.batch33.library.controller;
import com.cis.batch33.library.entity.LibraryBook;
import com.cis.batch33.library.model.Book;
import com.cis.batch33.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping("/{bookId}")
    public Book getBook(@PathVariable Integer bookId){

        return bookService.getBook(bookId);
    }

    // create a book
    @PostMapping
    public Book createBook(@RequestBody Book book){

        return bookService.createBook(book);
    }

}
