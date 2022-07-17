package com.example.webclientbooklibrary.booklibrary.model;

import com.example.webclientbooklibrary.booklibrary.enums.BookType;
import org.springframework.stereotype.Repository;


public class Book {

    String title, autor, isbn;
    BookType bookType;

    public Book(String title, String autor, String isbn, BookType bookType) {
        this.title = title;
        this.autor = autor;
        this.isbn = isbn;
        this.bookType = bookType;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public BookType getBookType() {
        return bookType;
    }

    public void setBookType(BookType bookType) {
        this.bookType = bookType;
    }
}
