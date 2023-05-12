package com.example.demo.services;

import com.example.demo.domain.Arthor;
import com.example.demo.domain.Book;
import com.example.demo.repositories.ArthorRepository;
import com.example.demo.repositories.BookRepository;
import org.springframework.stereotype.Service;

@Service
public class ArthorServiceImpl implements AuthorService{

    private final ArthorRepository arthorRepository;

    public ArthorServiceImpl(ArthorRepository arthorRepository) {
        this.arthorRepository = arthorRepository;
    }

    @Override
    public Iterable<Arthor> findAll() {
        return arthorRepository.findAll();
    }
}
