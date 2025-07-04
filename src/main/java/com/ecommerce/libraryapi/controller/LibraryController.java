package com.ecommerce.libraryapi.controller;


import com.ecommerce.libraryapi.model.Book;
import com.ecommerce.libraryapi.model.Library;
import com.ecommerce.libraryapi.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/libraries")
public class LibraryController {

    private final LibraryService libraryService;

    public LibraryController(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

    @PostMapping
    public ResponseEntity<Library> createLibrary(@RequestBody Library library) {
        return ResponseEntity.ok(libraryService.createLibraryWithBooks(library));
    }

    @PostMapping("/{libraryId}/books")
    public ResponseEntity<Book> addBook(@PathVariable Long libraryId,  @RequestBody Book book) {
        return ResponseEntity.ok(libraryService.addBookToLibrary(libraryId, book));
    }

    @DeleteMapping("/books/{bookId}")
    public ResponseEntity<String> deleteBook(@PathVariable Long bookId) {
        libraryService.deleteBookFromLibrary(bookId);
        return ResponseEntity.ok("Deleted successfully");
    }

    @PostMapping("/books/{bookId}/assign/{studentId}")
    public ResponseEntity<Book> assignBook(@PathVariable Long bookId, @PathVariable Long studentId) {
        return ResponseEntity.ok(libraryService.assignBookToStudent(studentId, bookId));
    }

    @GetMapping("/all")
    public ResponseEntity<List<Library>> getAllLibraries() {
        return ResponseEntity.ok(libraryService.getAllLibraries());
    }


}
