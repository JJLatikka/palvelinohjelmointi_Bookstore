package bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import bookstore.domain.Book;
import bookstore.domain.BookRepository;

@SpringBootApplication
public class BookstoreApplication {

	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {

		SpringApplication.run(BookstoreApplication.class, args);

	}

	@Bean
	public CommandLineRunner studentDemo(BookRepository repo) {
		return (args) -> {
			log.info("save a couple of students");
			repo.save(new Book("Kirja", "Kirjoittaja", 1, "007-1", 99.99));
			repo.save(new Book("Kirja", "Kirjoittaja", 1, "007-2", 99.99));

			log.info("fetch all books");
			for (Book b : repo.findAll()) {
				log.info(b.toString());
			}
		};
	}

}
