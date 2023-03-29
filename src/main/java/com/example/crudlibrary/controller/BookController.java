package com.example.crudlibrary.controller;

import com.example.crudlibrary.entity.Book;
import com.example.crudlibrary.service.InterfaceServiceBook;
import com.example.crudlibrary.service.ServiceBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/library")
public class BookController {
    @Autowired
    InterfaceServiceBook serviceBook;


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
    public ResponseEntity updateBook(@RequestBody  Book book){
        System.out.println("Id_ " + book.getId());
        Optional<Book> bookUpdated =  serviceBook.findBookbyId(book.getId());
        if (bookUpdated.isPresent()){

            serviceBook.updateBoook(book);
        }else{
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteBook(@PathVariable("id") Long id){
        serviceBook.deleteBook(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
