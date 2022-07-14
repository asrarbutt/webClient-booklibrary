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

   private final List<Book> books=new ArrayList<>(Arrays.asList(
            new Book("Java", "Peter", "1", BookType.E_BOOK))
    );



    public List<Book> getBooks() {
        return books;
    }

    public Book getBook(String isbn){
       Book book= books.stream().filter(e->e.isbn()==isbn).findFirst().get();
       if (book==null){
          throw new NoSuchElementException("Book with the ISBN= " + isbn +"not exists");
       }
/*
      List<Book> newBooks= books.stream().filter(e->e.isbn()==isbn).collect(Collectors.toList());
       if(newBooks.size() !=1){
           throw new IllegalStateException("Expected exactly one Book but got " + newBooks.size());
       }
       Book newBook=newBooks.get(0);
*/
        return book;
    }




}
