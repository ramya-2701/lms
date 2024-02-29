package com.cis.batch33.library.model;
<<<<<<< HEAD
import com.cis.batch33.library.entity.LibraryBook;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;

@Data
=======

>>>>>>> origin/master
public class Book {
    private Integer bookId;
    private String title;
    private String authorName;
    private Integer yearPublished;
    private Integer quantity;
<<<<<<< HEAD
    private List<BookIsbnDTO> bookIsbns;

}


=======
}
>>>>>>> origin/master
