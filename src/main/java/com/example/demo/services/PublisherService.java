package com.example.demo.services;

import com.example.demo.domain.Book;
import com.example.demo.domain.Publisher;

public interface PublisherService {

    Iterable<Publisher> findAll();
}
