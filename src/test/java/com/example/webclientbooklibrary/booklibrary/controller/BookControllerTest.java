package com.example.webclientbooklibrary.booklibrary.controller;

import com.example.webclientbooklibrary.booklibrary.Repo.BookRepo;
import com.example.webclientbooklibrary.booklibrary.enums.BookType;
import com.example.webclientbooklibrary.booklibrary.model.Book;
import com.example.webclientbooklibrary.booklibrary.service.BookService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BookControllerTest {

    @Test
    void getAllBook() {
        // Given

        BookRepo bookRepo = new BookRepo();
        BookService bookService = new BookService(bookRepo);
        // bookService.addBook(new Book("Java", "Müller", "1", BookType.E_BOOK));
        //bookService.addBook(new Book("Javascript", "Wali", "1", BookType.AUDIO_BOOK));

        //when
        List<Book> expected = List.of(
                new Book("Java", "Müller", "1", BookType.E_BOOK),
                new Book("Javascript", "Wali", "1", BookType.AUDIO_BOOK)
        );

        List<Book> actual = bookService.getBooks();

        //then
        Assertions.assertEquals(expected, actual);


    }


    @Test
    public void getOneBook() {
        //Given
        BookRepo bookRepo = new BookRepo();
        BookService bookService = new BookService(bookRepo);

        //when
        Book expected=new Book("Java", "Müller", "1", BookType.E_BOOK);
        Book actual=bookService.getBook("1");

        //then
        assertThat(actual).isEqualTo(expected);


    }

    @Test
    public void addBookTolist(){
        //given
        BookRepo bookRepo = new BookRepo();
        BookService bookService = new BookService(bookRepo);

        //when
       Book exp= bookService.addBook( new Book("Java", "Müller", "1", BookType.E_BOOK));

      boolean x= bookService.getBooks().contains(exp);


       //then
        Assertions.assertTrue(x);


    }

}
