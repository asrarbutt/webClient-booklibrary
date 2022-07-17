package com.example.webclientbooklibrary.booklibrary.controller;

import com.example.webclientbooklibrary.booklibrary.model.Book;
import com.example.webclientbooklibrary.booklibrary.model.BookApiListResponse;
import com.example.webclientbooklibrary.booklibrary.service.BookService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@RestController
@RequestMapping("book")
public class BookController {

    private WebClient webClient=WebClient
            .create("https://my-json-server.typicode.com/Flooooooooooorian/BookApi/");

    BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping()
    public List<Book> getBooks(){
        return bookService.getBooks();

    }

    @GetMapping(path = "{isbn}")
    public Book getBook(@PathVariable String isbn){

        return bookService.getBook(isbn);
    }

    @PostMapping
    public Book addBook(@RequestBody Book newBook){
        System.out.println("haha    " +newBook);
       return bookService.addBook(newBook);


    }



    @DeleteMapping(path = "books/{isbn}")
    public List<Book> deleteBook(@PathVariable String isbn){
        return bookService.deleteBook(isbn);
    }

    @PutMapping("{isbn}")
    public Book addBookById(@PathVariable String isbn, @RequestBody Book book){
     return    bookService.addBookById(isbn, book);


    }



    //Bonus
/*

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

 */
}
