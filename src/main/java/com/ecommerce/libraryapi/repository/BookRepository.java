package com.ecommerce.libraryapi.repository;

import com.ecommerce.libraryapi.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
