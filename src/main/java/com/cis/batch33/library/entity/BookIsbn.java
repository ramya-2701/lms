package com.cis.batch33.library.entity;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;
@Entity
@Table(name="book_isbn")
@Data
public class BookIsbn {
    @Id
    private Long isbn;
    @Column(name = "book_id", insertable = false, updatable = false)
    private Integer bookId;
    @ManyToOne
    @JoinColumn(name = "book_id")
    private LibraryBook libraryBook;

}
