package com.example.demo.controllers;

import com.example.demo.services.BookService;
import com.example.demo.services.PublisherService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PublisherController {
    private final PublisherService publisherService;

    public PublisherController(PublisherService publisherService) {
        this.publisherService = publisherService;
    }

    //create a method that takes in a Model
    // Model is Spring Component
    @RequestMapping("/publishers")  // when we go to /books, methods gets called
    public String getBooks(Model model){
        model.addAttribute("publishers", publisherService.findAll());
        //findall() method means a list of Books
        // model is a view object, the HTML content


        return "publishers";
    }
}
