package com.example.demo.bootstrap;

import com.example.demo.domain.Arthor;
import com.example.demo.domain.Book;
import com.example.demo.domain.Publisher;
import com.example.demo.repositories.ArthorRepository;
import com.example.demo.repositories.BookRepository;
import com.example.demo.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

//initialzing Spring Data
//works with the repositories from repo directory

//Application Runner and Command Line Runner interfaces lets you to execute the code after the Spring Boot application is started. You can use these interfaces to perform any actions immediately after the application has started.

// @Componenys creates Spring Bean
@Component
public class BootstrapData implements CommandLineRunner {

    // used to declare Spring Data JPA repositories
    private final ArthorRepository authorRepository;
    private final BookRepository bookRepository;

    private final PublisherRepository publisherRepository;

    public BootstrapData(ArthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Arthor eric = new Arthor();
        eric.setFirstName("Eric");
        eric.setLastName("Evans");

        Book dd = new Book();
        dd.setTitle("Domain Driven Design");
        dd.setIsbn("123456");

        Publisher publisher = new Publisher();
        publisher.setPublisherName("My Publisher");
        publisher.setAddress("123 Main");
        Publisher publisherSaved = publisherRepository.save(publisher);

        // saving means new obejct is retruend from repo interface
        Arthor ericSaved = authorRepository.save(eric);
        Book ddSaved = bookRepository.save(dd);

        ddSaved.setPublisher(publisherSaved);


        bookRepository.save(ddSaved);

        // adding association between the arthors and books
        ericSaved.getBooks().add(ddSaved);
        ddSaved.getAuthors().add(ericSaved); // need to do both cuz many-to-many

        authorRepository.save(ericSaved); // persisting changes
        bookRepository.save(ddSaved);
        publisherRepository.save(publisherSaved);

        System.out.println("Arthor Count: " + authorRepository.count());
        System.out.println("Book Count: " + bookRepository.count());
        System.out.println("Publisher Count: " + publisherRepository.count());

    }
}
