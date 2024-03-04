package com.cis.batch33.library.service;

import com.cis.batch33.library.entity.Book;
import com.cis.batch33.library.entity.BookIsbn;
import com.cis.batch33.library.entity.Checkout;
import com.cis.batch33.library.entity.LibraryMember;
import com.cis.batch33.library.model.BookDTO;
import com.cis.batch33.library.model.CheckoutDTO;
import com.cis.batch33.library.model.Member;
import com.cis.batch33.library.repository.BookRepository;
import com.cis.batch33.library.repository.CheckoutRepository;
import com.cis.batch33.library.repository.LIbraryMemberRepository;
import com.cis.batch33.library.repository.BookIsbnRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class CheckoutService {
    @Autowired
    private CheckoutRepository checkoutRepository;
    @Autowired
    private LIbraryMemberRepository lIbraryMemberRepository;
    @Autowired
    private BookIsbnRepository bookIsbnRepository;
    @Autowired
    private BookRepository bookRepository;


    @Autowired
    private ModelMapper modelMapper;

    public CheckoutDTO getData(Integer id) {
        Checkout checkout = checkoutRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Checkout not found with id: " + id));
        return modelMapper.map(checkout, CheckoutDTO.class);
    }
    public CheckoutDTO createCheckout(CheckoutDTO checkoutDTO) {
        BookIsbn bookIsbn = bookIsbnRepository.findById(checkoutDTO.getIsbn())
                .orElseThrow(() -> new IllegalArgumentException("Book ISBN not found"));
        LibraryMember member = lIbraryMemberRepository.findById(checkoutDTO.getMemberId())
                .orElseThrow(() -> new IllegalArgumentException("Member not found"));
        Book book = bookIsbn.getBook();
        if (book.getQuantity() > 0) {
            book.setQuantity(book.getQuantity() - 1);
            bookRepository.save(book);
        } else {
            throw new IllegalStateException("Book is out of stock");
        }
        Checkout checkout = modelMapper.map(checkoutDTO, Checkout.class);
        checkout.setBookIsbn(bookIsbn);
        checkout.setLibraryMember(member);
        Checkout savedCheckout = checkoutRepository.save(checkout);
        return modelMapper.map(savedCheckout, CheckoutDTO.class);
    }
    public CheckoutDTO updateCheckout( Integer id, CheckoutDTO checkoutDTO) {
        Checkout checkout = checkoutRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("Checkout not found"));
        BookIsbn bookIsbn = bookIsbnRepository.findById(checkoutDTO.getIsbn())
                .orElseThrow(() -> new IllegalArgumentException("Book ISBN not found"));
        LibraryMember member = lIbraryMemberRepository.findById(checkoutDTO.getMemberId())
                .orElseThrow(() -> new IllegalArgumentException("Member not found"));

        // Checking if the book has been returned
        boolean isReturned = checkoutDTO.isReturned();
        if (isReturned) {
            // Adding quantity by one to the book table
            Book book = bookIsbn.getBook();
            book.setQuantity(book.getQuantity() + 1);
            bookRepository.save(book);
        }

        Checkout checkout1 = modelMapper.map(checkoutDTO, Checkout.class);
        checkout1.setBookIsbn(bookIsbn);
        checkout1.setLibraryMember(member);

        Checkout savedCheckout = checkoutRepository.save(checkout1);
        checkoutDTO.setId(savedCheckout.getId());
        return modelMapper.map(savedCheckout, CheckoutDTO.class);
    }
}
