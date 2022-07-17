package com.example.webclientbooklibrary.service;

import com.example.webclientbooklibrary.booklibrary.Repo.BookRepo;
import com.example.webclientbooklibrary.booklibrary.enums.BookType;
import com.example.webclientbooklibrary.booklibrary.model.Book;
import com.example.webclientbooklibrary.booklibrary.service.BookService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.mockito.Mockito.*;

public class BookServiceTest {

    BookRepo bookRepo=mock(BookRepo.class);
    BookService bookService=new BookService(bookRepo);

    @Test
    void getAllBooks(){
        //Given

        when(bookRepo.getBooks()).thenReturn(List.of(
                new Book("Java", "Müller", "1", BookType.E_BOOK),
                new Book("Javascript", "Wali", "1", BookType.AUDIO_BOOK)
        ));

        //when
        List<Book> expected=List.of(
                new Book("Java", "Müller", "1", BookType.E_BOOK),
                new Book("Javascript", "Wali", "1", BookType.AUDIO_BOOK)
        );
        List<Book> actual= bookRepo.getBooks();
        verify(bookRepo).getBooks();

        Assertions.assertEquals(expected, actual);
    }





}
