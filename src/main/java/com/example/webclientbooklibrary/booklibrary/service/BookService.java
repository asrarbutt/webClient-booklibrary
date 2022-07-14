package com.example.webclientbooklibrary.booklibrary.service;

import com.example.webclientbooklibrary.booklibrary.Repo.BookRepo;
import com.example.webclientbooklibrary.booklibrary.model.Book;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    BookRepo bookRepo;

    public BookService(BookRepo bookRepo) {
        this.bookRepo = bookRepo;
    }


}
