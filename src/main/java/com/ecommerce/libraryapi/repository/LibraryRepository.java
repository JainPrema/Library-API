package com.ecommerce.libraryapi.repository;

import com.ecommerce.libraryapi.model.Library;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibraryRepository extends JpaRepository<Library, Long> {}
