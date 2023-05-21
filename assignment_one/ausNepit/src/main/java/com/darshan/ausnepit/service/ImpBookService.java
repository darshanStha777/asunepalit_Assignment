package com.darshan.ausnepit.service;

import com.darshan.ausnepit.model.Book;

import java.util.List;

public interface ImpBookService {
    List<Book> getAllBooks();

    Book getBookById(int id);

    Book addBook(Book book);

    Book updateBook(Book book);

   String  deleteBook(int id);

    List<Book> getAllActiveBooks();

    String activateBook(int id);

    String deactivateBook(int id);
}
