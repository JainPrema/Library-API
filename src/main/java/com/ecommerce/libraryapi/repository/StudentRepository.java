package com.ecommerce.libraryapi.repository;

import com.ecommerce.libraryapi.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
