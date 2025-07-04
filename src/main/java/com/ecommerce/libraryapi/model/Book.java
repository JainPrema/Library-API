package com.ecommerce.libraryapi.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;


    @ManyToOne
    @JoinColumn(name ="library_id")
    @JsonBackReference
    private Library library;


    @ManyToOne
    @JoinColumn(name="student_id")
    private Student student;
}
