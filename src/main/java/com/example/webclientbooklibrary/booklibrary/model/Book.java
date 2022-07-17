package com.example.webclientbooklibrary.booklibrary.model;

import com.example.webclientbooklibrary.booklibrary.enums.BookType;
import org.springframework.stereotype.Repository;

import java.util.Objects;


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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(title, book.title) && Objects.equals(autor, book.autor) && Objects.equals(isbn, book.isbn) && bookType == book.bookType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, autor, isbn, bookType);
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", autor='" + autor + '\'' +
                ", isbn='" + isbn + '\'' +
                ", bookType=" + bookType +
                '}';
    }
}
