package com.cis.batch33.library.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name="book_isbn")
@Data
public class BookIsbn {

    @Id
    private Integer isbn;

    @ManyToOne
    @JoinColumn(name="book_id")
    private Book book;

    @OneToMany(mappedBy = "bookIsbn",cascade = CascadeType.ALL)
    private List<Checkout> checkouts;
}
