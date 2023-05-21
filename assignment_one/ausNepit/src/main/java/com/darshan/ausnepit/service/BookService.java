package com.darshan.ausnepit.service;

import com.darshan.ausnepit.model.Book;
import com.darshan.ausnepit.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService implements ImpBookService{

    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book getBookById(int id) {
        return bookRepository.findById(id).orElse(null);
    }

    @Override
    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Book updateBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public String deleteBook(int id) {
        if (bookRepository.existsById(id)) {
            bookRepository.deleteById(id);
            return "Book deleted successfully.";
        }
        return "Book not found.";
    }

    @Override
    public List<Book> getAllActiveBooks() {
        return bookRepository.findByIsActiveTrue();
    }

    @Override
    public String activateBook(int id) {
        Book book = bookRepository.findById(id).orElse(null);
        if (book != null) {
            book.setActive(true);
            bookRepository.save(book);
            return "Book activated successfully.";
        }
        return "Book not found.";
    }

    @Override
    public String deactivateBook(int id) {
        Book book = bookRepository.findById(id).orElse(null);
        if (book != null) {
            book.setActive(false);
            bookRepository.save(book);
            return "Book deactivated successfully.";
        }
        return "Book not found.";
    }
}
