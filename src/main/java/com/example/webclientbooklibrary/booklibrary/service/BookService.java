package com.example.webclientbooklibrary.booklibrary.service;

import com.example.webclientbooklibrary.booklibrary.Repo.BookRepo;
import com.example.webclientbooklibrary.booklibrary.model.Book;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;

@Service
public class BookService {

    BookRepo bookRepo;
    List<Book> bookList;

    public BookService(BookRepo bookRepo) {
        this.bookRepo = bookRepo;
        this.bookList=new ArrayList<>(this.bookRepo.getBooks());
    }


    public List<Book> getBooks(){

        return bookRepo.getBooks();
    }

    public Book getBook(String isbn){

        Book book= bookList.stream().filter(e-> Objects.equals(e.isbn(), isbn)).findFirst().get();
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
    public List<Book> deleteBook(String isbn){
       Book book= bookRepo.getBooks().stream().filter(e-> Objects.equals(e.isbn(), isbn)).findFirst().get();
        if (book==null){
            throw new NoSuchElementException("Book with the ISBN= " + isbn +"not exists");
        }
        bookList.remove(book);

        return bookList;
    }
}
