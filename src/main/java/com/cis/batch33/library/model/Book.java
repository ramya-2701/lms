package com.cis.batch33.library.model;
import com.cis.batch33.library.entity.LibraryBook;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;

@Data
public class Book {
    private Integer bookId;
    private String title;
    private String authorName;
    private Integer yearPublished;
    private Integer quantity;
    private List<BookIsbnDTO> bookIsbns;

}


