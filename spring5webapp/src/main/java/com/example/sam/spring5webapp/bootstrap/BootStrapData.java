package com.example.sam.spring5webapp.bootstrap;

import com.example.sam.spring5webapp.domain.Author;
import com.example.sam.spring5webapp.domain.Book;
import com.example.sam.spring5webapp.domain.Publisher;
import com.example.sam.spring5webapp.repositories.AuthorRepository;
import com.example.sam.spring5webapp.repositories.BookRepository;
import com.example.sam.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "123132");
        Publisher publisher = new Publisher("abc", "6090 Iona Drive", "Vancouver", "BC", "V6T1K2");
        eric.getBooks().add((ddd));
        ddd.getAuthors().add(eric);

        publisherRepository.save(publisher);

        System.out.println("Publisher Count: " + publisherRepository.count());

        ddd.setPublisher(publisher);
        publisher.getBooks().add(ddd);

        authorRepository.save(eric);
        bookRepository.save(ddd);
        publisherRepository.save(publisher);

        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Developer", "812632");
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        noEJB.setPublisher(publisher);
        publisher.getBooks().add(noEJB);

        authorRepository.save(rod);
        bookRepository.save(noEJB);
        publisherRepository.save(publisher);


        System.out.println("Started in Bootstrap");
        System.out.println("Number of Books: " + bookRepository.count() );
        System.out.println("Publisher Number of Books: " + publisher.getBooks().size());
    }
}
