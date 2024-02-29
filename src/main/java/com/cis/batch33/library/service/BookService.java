package com.cis.batch33.library.service;
import com.cis.batch33.library.entity.BookIsbn;
import com.cis.batch33.library.entity.LibraryBook;
import com.cis.batch33.library.model.BookIsbnDTO;
import com.cis.batch33.library.entity.LibraryMember;
import com.cis.batch33.library.model.*;
import com.cis.batch33.library.repository.LibraryBookRepository;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;
@Service
public class BookService {
    @Autowired
    private LibraryBookRepository bookRepository;
    public BookService(LibraryBookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book createBook(Book book) {
        LibraryBook libraryBook = new LibraryBook();
        // Manually map properties from Book to LibraryBook
        BeanUtils.copyProperties(book, libraryBook);
        List<BookIsbn> bookIsbns = book.getBookIsbns().stream().map( bi ->
        {
            BookIsbn bookIsbn = new BookIsbn();
            BeanUtils.copyProperties(bi, bookIsbn);
            return bookIsbn;
        }).collect(Collectors.toList());
        libraryBook.setBookIsbns(bookIsbns);

        libraryBook.getBookIsbns()
                .forEach( i -> i.setLibraryBook(libraryBook));
        LibraryBook b= bookRepository.save(libraryBook);
        Book rb = new Book();
        BeanUtils.copyProperties(b, rb);
        List<BookIsbnDTO> bookIsbnDTOS =  b.getBookIsbns().stream().map( eidto ->
                {
                    BookIsbnDTO dtoIsbn = new BookIsbnDTO();
                    dtoIsbn.setBookId(eidto.getBookId());
                    dtoIsbn.setIsbn(eidto.getIsbn());
                    return dtoIsbn;
                }).toList();
        rb.setBookIsbns(bookIsbnDTOS);

        return rb;

    }

    public Book getBook(Integer bookId) {

        Optional<LibraryBook> bookOptional =
                bookRepository.findById(bookId);
        LibraryBook libraryBook =
                bookOptional.orElse(new LibraryBook());

        Book book = new Book();
        book.setBookId(libraryBook.getBookId());
        book.setTitle(libraryBook.getTitle());
        book.setAuthorName(libraryBook.getAuthorName());
        book.setYearPublished(libraryBook.getYearPublished());
        book.setQuantity(libraryBook.getQuantity());

        List<BookIsbnDTO> bookIsbnDTOS =
                libraryBook.getBookIsbns().stream().map(b -> {
                    BookIsbnDTO bdo = new BookIsbnDTO();
                    bdo.setIsbn(b.getIsbn());
                    bdo.setBookId(b.getBookId());
                    return bdo;
                }).collect(Collectors.toList());
        book.setBookIsbns(bookIsbnDTOS);

        return book;


    }

}
