package com.example.webclientbooklibrary.booklibrary.controller;

import com.example.webclientbooklibrary.booklibrary.service.BookService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class BookController {

    BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }


}
