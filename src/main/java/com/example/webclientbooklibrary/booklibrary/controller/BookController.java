package com.example.webclientbooklibrary.booklibrary.controller;

import com.example.webclientbooklibrary.booklibrary.model.Book;
import com.example.webclientbooklibrary.booklibrary.model.BookApiListResponse;
import com.example.webclientbooklibrary.booklibrary.service.BookService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@RestController
@RequestMapping("/")
public class BookController {

    private WebClient webClient=WebClient
            .create("https://my-json-server.typicode.com/Flooooooooooorian/BookApi/");

    BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("books")
    public List<Book> getBooks(){
        return bookService.getBooks();
    }

    @GetMapping(path = "books/{isbn}")
    public Book getBook(@PathVariable String isbn){

        return bookService.getBook(isbn);
    }

    @DeleteMapping(path = "books/{isbn}")
    public List<Book> deleteBook(@PathVariable String isbn){
        return bookService.deleteBook(isbn);
    }


    //Bonus

    @GetMapping(path = "/books/{isbn}")
    public void getFlorianBook(@PathVariable String isbn){

      BookApiListResponse response=  webClient.get()
                .uri("/books/{isbn}")
                .retrieve()
                .toEntity(BookApiListResponse.class)
                .block()
                .getBody();
        System.out.println(response);

    }
}
