package com.example.crudlibrary.controller;

import com.example.crudlibrary.entity.Book;
import com.example.crudlibrary.repository.BookRepository;
import com.example.crudlibrary.service.ServiceBook;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Access;
import java.util.List;

@RestController
@RequestMapping("/api/library")
public class BookController {
    @Autowired
    ServiceBook serviceBook;


    @GetMapping("/prueba")
    public String prueba(){
        return "Prueba msg";
    }
    @PostMapping("/add")
    public ResponseEntity addNewBook(@RequestBody Book book){
        Book insertedBook = serviceBook.createBook(book);
        if(insertedBook==null){
            System.out.println("NO se ha insertado el book");
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }else{
            return new ResponseEntity(HttpStatus.OK);
        }
    }
    @GetMapping("/all")
    public ResponseEntity<List<Book>> getAllBooks(){
        List<Book> books = serviceBook.finAllBooks();
        return new ResponseEntity<>(books, HttpStatus.OK);
    }
    @PostMapping("/update")
    public ResponseEntity updateBook(Book book){
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteBook(Long id){
        serviceBook.deleteBook(id);
    }
}
