package com.edu.ulab.app.repository;

import com.edu.ulab.app.entity.Book;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import javax.persistence.LockModeType;
import java.util.List;
import java.util.Optional;

public interface BookRepository extends CrudRepository<Book, Long> {

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    Book findBookById(Long id);


    List<Book> findAllByPersonId(Long userId);
}
