package com.example.crudlibrary.service;

import com.example.crudlibrary.entity.Book;
import com.example.crudlibrary.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ServiceBook implements  InterfaceServiceBook{

    @Autowired
    BookRepository bookRepository;

    @Override
    public List<Book> finAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book createBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public void updateBoook(Book book) {
        Optional<Book> bookOptional = bookRepository.findById(book.getId());
        Book bookUpdated = bookOptional.get();
        bookUpdated.setName(book.getName());
        bookUpdated.setDescription(book.getDescription());
        bookUpdated.setPrice(book.getPrice());
        bookRepository.save(bookUpdated);


    }

    @Override
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);

    }

    @Override
    public Optional<Book> findBookbyId(Long id) {
        return Optional.empty();
    }
}
