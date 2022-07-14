package com.example.webclientbooklibrary.booklibrary.model;

import com.example.webclientbooklibrary.booklibrary.enums.BookType;
import org.springframework.stereotype.Repository;


public record Book(String title, String autor, String isbn, BookType bookType) {
}
