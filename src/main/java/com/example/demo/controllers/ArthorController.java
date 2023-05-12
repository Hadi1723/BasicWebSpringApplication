package com.example.demo.controllers;

import com.example.demo.services.AuthorService;
import com.example.demo.services.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ArthorController {
    private final AuthorService authorService;

    public ArthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    //create a method that takes in a Model
    // Model is Spring Component
    @RequestMapping("/authors")  // when we go to /books, methods gets called
    public String getAuthors(Model model){
        model.addAttribute("authors", authorService.findAll());
        //findall() method means a list of Books
        // model is a view object, the HTML content


        return "authors";
    }
}
