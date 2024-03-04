package com.cis.batch33.library.controller;

import com.cis.batch33.library.entity.Book;
import com.cis.batch33.library.model.BookDTO;
import com.cis.batch33.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/{bookId}")
    public BookDTO getBook(@PathVariable Integer bookId){
        return bookService.getBook(bookId);
    }

    @GetMapping
    public List<BookDTO> getAllBooks(){
        return bookService.getAllBooks();
    }

    @PostMapping
    public BookDTO createBook(@RequestBody BookDTO bookDto){
        return bookService.createBook(bookDto);
    }

    @PutMapping
    public BookDTO updateBook(@RequestBody BookDTO bookDto){
        return bookService.updateBook(bookDto);
    }

    @DeleteMapping("/{bookId}")
    public void deleteBook(@PathVariable Integer bookId){
         bookService.deleteBook(bookId);
    }



}
