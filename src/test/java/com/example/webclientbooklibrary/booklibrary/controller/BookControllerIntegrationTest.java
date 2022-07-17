package com.example.webclientbooklibrary.booklibrary.controller;

import com.example.webclientbooklibrary.booklibrary.Repo.BookRepo;
import com.example.webclientbooklibrary.booklibrary.enums.BookType;
import com.example.webclientbooklibrary.booklibrary.model.Book;
import com.example.webclientbooklibrary.booklibrary.service.BookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class BookControllerIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    BookRepo bookRepo;

    @Autowired
    BookService bookService;

    @Test
    void getAllBooks() throws Exception {
        //given
        Book book1 = new Book("Java", "Müller", "1", BookType.E_BOOK);
        Book book2 = new Book("Javascript", "Wali", "1", BookType.AUDIO_BOOK);


        mockMvc.perform(get("/book")).andExpect(status().isOk()).andExpect(content().json("""
                [
                    {
                        "title": "Java",
                        "autor": "Müller",
                        "isbn": "1",
                        "bookType": "E_BOOK"
                    },
                    {
                        "title": "Javascript",
                        "autor": "Wali",
                        "isbn": "1",
                        "bookType": "AUDIO_BOOK"
                    }
                ]"""));


    }


    @Test
    void addBook() throws Exception {
        //GIVEN
        //WHEN & THEN
        mockMvc.perform(
                        put("/book/1234")
                                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                                .content("""
                        {"title":"Javascript","autor":"Wali","isbn":"1","bookType":"AUDIO_BOOK"}
                        """))
                .andExpect(status().is(200))
                .andExpect(content().json("""
                       {"title":"Javascript","autor": "Wali","isbn":"1","bookType":"AUDIO_BOOK"}"""));
    }

}
