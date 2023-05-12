package com.example.demo.services;

import com.example.demo.domain.Publisher;
import com.example.demo.repositories.PublisherRepository;
import org.springframework.stereotype.Service;

@Service
public class PublisherServiceImpl implements PublisherService{

    private final PublisherRepository publisherRepository;

    public PublisherServiceImpl(PublisherRepository publisherRepository) {
        this.publisherRepository = publisherRepository;
    }

    @Override
    public Iterable<Publisher> findAll() {
        return publisherRepository.findAll();
    }
}
