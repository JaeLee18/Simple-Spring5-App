package jj.spring.spring5web.bootstrap;

import jj.spring.spring5web.domain.Author;
import jj.spring.spring5web.domain.Book;
import jj.spring.spring5web.domain.Publisher;
import jj.spring.spring5web.repository.AuthorRepository;
import jj.spring.spring5web.repository.BookRepository;
import jj.spring.spring5web.repository.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * Created by jaejoonglee on 2020/02/09.
 */
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

    public void run(String... strings) throws Exception {
        Author eric = new Author("Eric", "Evans");
        Book book = new Book("Domain Desing", "123123");
        Publisher jlee = new Publisher("lee", "address", "00000", "CA", "SF");
        publisherRepository.save(jlee);
        eric.getBook().add(book);
        book.getAuthors().add(eric);
        book.setPublisher(jlee);
        jlee.getBooks().add(book);

        authorRepository.save(eric);
        bookRepository.save(book);
        publisherRepository.save(jlee);

        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Dev", "456456");

        rod.getBook().add(noEJB);
        noEJB.getAuthors().add(rod);
        noEJB.setPublisher(jlee);
        jlee.getBooks().add(noEJB);

        authorRepository.save(rod);
        bookRepository.save(noEJB);
        publisherRepository.save(jlee);

        System.out.println("Started in Boostrap");
        System.out.println("Bookrepository count: " + bookRepository.count());
        System.out.println("PublisherRepository count: " + publisherRepository.count());
        System.out.println("pubisher book size: " + jlee.getBooks().size());


    }
}
