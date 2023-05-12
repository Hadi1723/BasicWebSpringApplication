package com.example.demo.controllers;

import com.example.demo.services.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

// we need service to that extract all persistent logic from comrtoller to service

@Controller
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    //create a method that takes in a Model
    // Model is Spring Component
    @RequestMapping("/books")  // when we go to /books, methods gets called
    public String getBooks(Model model){
        model.addAttribute("books", bookService.findAll());
        //findall() method means a list of Books
        // model is a view object, the HTML content


        return "books";
    }
}
