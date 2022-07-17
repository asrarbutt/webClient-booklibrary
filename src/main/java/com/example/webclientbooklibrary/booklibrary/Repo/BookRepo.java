package com.example.webclientbooklibrary.booklibrary.Repo;

import com.example.webclientbooklibrary.booklibrary.enums.BookType;
import com.example.webclientbooklibrary.booklibrary.model.Book;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Repository
public class BookRepo {

   private final List<Book> books=new ArrayList<>(
           Arrays.asList(
           new Book("Java", "Müller", "1", BookType.E_BOOK),
                   new Book("Javascript", "Wali", "1", BookType.AUDIO_BOOK)


           )



    );



    public List<Book> getBooks() {
        return books;
    }






}
