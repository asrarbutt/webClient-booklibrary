package com.example.webclientbooklibrary.booklibrary.model;

import com.example.webclientbooklibrary.booklibrary.enums.BookType;

public record Book(String title, String autor, String isbn, BookType bookType) {
}
