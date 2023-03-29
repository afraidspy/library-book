package com.example.crudlibrary.service;

import com.example.crudlibrary.entity.Book;

import java.util.List;
import java.util.Optional;

public interface InterfaceServiceBook {

    List<Book> finAllBooks();

    Book createBook(Book book);

    void updateBoook(Book book);

    void deleteBook(Long id);

    Optional<Book> findBookbyId(Long id);
}
