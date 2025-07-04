package com.ecommerce.libraryapi.service;

import com.ecommerce.libraryapi.model.Book;
import com.ecommerce.libraryapi.model.Library;
import com.ecommerce.libraryapi.model.Student;
import com.ecommerce.libraryapi.repository.BookRepository;
import com.ecommerce.libraryapi.repository.LibraryRepository;
import com.ecommerce.libraryapi.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibraryService {
    private final LibraryRepository libraryRepository;
    private final StudentRepository studentRepository;
    private final BookRepository bookRepository;

    public LibraryService(LibraryRepository libraryRepository, StudentRepository studentRepository, BookRepository bookRepository) {
        this.libraryRepository = libraryRepository;
        this.studentRepository = studentRepository;
        this.bookRepository = bookRepository;

    }

    public Library createLibraryWithBooks(Library library) {
        for (Book book: library.getBooks()){
            book.setLibrary(library);
        }
        return libraryRepository.save(library);
    }

    public Book addBookToLibrary(Long libraryId, Book book) {
        Library library = libraryRepository.findById(libraryId).orElseThrow(() -> new RuntimeException("Library not found"));
        book.setLibrary(library);
        return bookRepository.save(book);
    }

    public void deleteBookFromLibrary(Long bookId) {
        bookRepository.deleteById(bookId);
    }

    public Book assignBookToStudent(Long studentId, Long bookId) {
        Student student = studentRepository.findById(studentId).orElseThrow(() -> new RuntimeException("Student not found"));
        Book book = bookRepository.findById(bookId).orElseThrow(() -> new RuntimeException("Book not found"));
        book.setStudent(student);
        return bookRepository.save(book);
    }

    public List<Library> getAllLibraries() {
         return libraryRepository.findAll();
    }





}
