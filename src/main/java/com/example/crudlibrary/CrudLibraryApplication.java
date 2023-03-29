package com.example.crudlibrary;

import com.example.crudlibrary.entity.Book;
import com.example.crudlibrary.service.ServiceBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class CrudLibraryApplication implements ApplicationRunner {

   @Autowired
   private ServiceBook bookService;
    public static void main(String[] args) {
        SpringApplication.run(CrudLibraryApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        List<Book> books =  bookService.finAllBooks();

        if (books != null &&  books.isEmpty()) {

            Book book1 = Book.builder().name("Book 1").description("description of book 1").price(12.5).build();
            Book book2 = Book.builder().name("Book 2").description("description of book 1").price(15).build();
            Book book3 = Book.builder().name("Book 3").description("description of book 1").price(20).build();

            Arrays.asList(book1, book2, book3).forEach(b -> bookService.createBook(b));

            System.out.println("Book added");
        }

    }
}
