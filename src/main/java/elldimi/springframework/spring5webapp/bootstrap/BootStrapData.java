package elldimi.springframework.spring5webapp.bootstrap;

import elldimi.springframework.spring5webapp.domain.Author;
import elldimi.springframework.spring5webapp.domain.Book;
import elldimi.springframework.spring5webapp.domain.Publisher;
import elldimi.springframework.spring5webapp.repositories.AuthorRepository;
import elldimi.springframework.spring5webapp.repositories.BookRepository;
import elldimi.springframework.spring5webapp.repositories.PublisherRepository;
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

        Publisher publisher = new Publisher();
        publisher.setName("HarperCollins Publishers");
        publisher.setCity("New York");
        publisher.setAddress("195 Broadway");

        this.publisherRepository.save(publisher);

        System.out.println("Publisher count: " + publisherRepository.count());

        Author joe = new Author("Joe", "Hill");
        Book horns = new Book("Horns", "123123");

        joe.getBooks().add(horns);
        horns.getAuthors().add(joe);

        horns.setPublisher(publisher);
        publisher.getBooks().add(horns);

        this.authorRepository.save(joe);
        this.bookRepository.save(horns);
        this.publisherRepository.save(publisher);

        Author stephen = new Author("Stephen", "King");
        Book firestarter = new Book("Firestarter", "456456");

        stephen.getBooks().add(firestarter);
        firestarter.getAuthors().add(stephen);

        firestarter.setPublisher(publisher);
        publisher.getBooks().add(firestarter);

        this.authorRepository.save(stephen);
        this.bookRepository.save(firestarter);
        this.publisherRepository.save(publisher);

        System.out.println("Number of books: " + this.bookRepository.count());
        System.out.println("Publisher Number of Books: " + publisher.getBooks().size());

    }
}
