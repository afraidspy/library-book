package com.example.crudlibrary.controller;

import com.example.crudlibrary.entity.Book;
import com.example.crudlibrary.repository.BookRepository;
import com.example.crudlibrary.service.ServiceBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.Access;

@RestController
public class BookController {
    @Autowired
    ServiceBook serviceBook;


    @GetMapping("/prueba")
    public String prueba(){
        return "Prueba msg";
    }
    @GetMapping("/add")
    public void createBook(){

        Book book = new Book();

        book.setName("Java");
        book.setPrice(3000);
        book.setDescription("Como aprender a programar en Java");

        serviceBook.createBook(book);
        System.out.println("Se ha insertado el book");

    }
}
