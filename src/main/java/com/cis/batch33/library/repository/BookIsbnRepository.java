package com.cis.batch33.library.repository;

import com.cis.batch33.library.entity.BookIsbn;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookIsbnRepository extends JpaRepository<BookIsbn, Integer> {

}
