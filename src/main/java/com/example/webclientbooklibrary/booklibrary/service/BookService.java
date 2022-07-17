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
   // List<Book> bookList;

    public BookService(BookRepo bookRepo) {
        this.bookRepo = bookRepo;
        //this.bookList=new ArrayList<>(this.bookRepo.getBooks());
    }


    public List<Book> getBooks(){

        return bookRepo.getBooks();
    }

    public Book getBook(String isbn){

        Book book= bookRepo.getBooks().stream().filter(e-> Objects.equals(e.getIsbn(), isbn)).findFirst().get();
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
       Book book= bookRepo.getBooks().stream().filter(e-> Objects.equals(e.getIsbn(), isbn)).findFirst().get();
        if (book==null){
            throw new NoSuchElementException("Book with the ISBN= " + isbn +"not exists");
        }
        bookRepo.getBooks().remove(book);
        List<Book> list=bookRepo.getBooks();

        return list;
    }


    public Book updateBook(Book book, String isbn){

     Book book1=  bookRepo.getBooks().stream().filter(e-> {
            if (e.getIsbn().equals(isbn)){
                e.setTitle(book.getTitle());
                e.setBookType(book.getBookType());
                e.setAutor(book.getAutor());

            }
            return true;

        }).findAny().get();
return book1;
    }


    public Book addBook(Book newBook) {
        return bookRepo.addBook(newBook);
    }

    public Book addBookById(String isbn, Book book) {
       return bookRepo.addBook(book);
    }
}
