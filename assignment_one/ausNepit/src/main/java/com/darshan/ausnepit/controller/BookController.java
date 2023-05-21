package com.darshan.ausnepit.controller;

import com.darshan.ausnepit.model.Book;
import com.darshan.ausnepit.service.ImpBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ausnepit")
public class BookController {
    @Autowired
    private ImpBookService bookService;

    @GetMapping("/books")
    public ResponseEntity<List<Book>> getAllBooks() {
        List<Book> books = bookService.getAllBooks();
        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    @GetMapping("/book/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable int id) {
        Book book = bookService.getBookById(id);
        if (book != null) {
            return new ResponseEntity<>(book, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/books")
    public ResponseEntity<Book> addBook(@RequestBody Book book) {
        Book newBook = bookService.addBook(book);
        return new ResponseEntity<>(newBook, HttpStatus.CREATED);
    }

    @PutMapping("/book/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable int id, @RequestBody Book book) {
        Book updatedBook = bookService.updateBook(book);
        if (updatedBook != null) {
            return new ResponseEntity<>(updatedBook, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/book/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable int id) {
        String message = bookService.deleteBook(id);
        if (message.equals("Book deleted successfully.")) {
            return new ResponseEntity<>(message, HttpStatus.OK);
        }
        return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
    }

    @GetMapping("/active")
    public ResponseEntity<List<Book>> getAllActiveBooks() {
        List<Book> activeBooks = bookService.getAllActiveBooks();
        return new ResponseEntity<>(activeBooks, HttpStatus.OK);
    }

    @PutMapping("/book/{id}/activate")
    public ResponseEntity<String> activateBook(@PathVariable int id) {
        String message = bookService.activateBook(id);
        if (message.equals("Book activated successfully.")) {
            return new ResponseEntity<>(message, HttpStatus.OK);
        }
        return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
    }

    @PutMapping("/book/{id}/deactivate")
    public ResponseEntity<String> deactivateBook(@PathVariable int id) {
        String message = bookService.deactivateBook(id);
        if (message.equals("Book deactivated successfully.")) {
            return new ResponseEntity<>(message, HttpStatus.OK);
        }
        return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
    }



}
