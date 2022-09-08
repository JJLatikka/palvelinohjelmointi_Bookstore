package bookstore;

import java.util.Arrays;

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
	public CommandLineRunner bookstoreDemo(BookRepository repo) {
		return (args) -> {
			log.info("save a couple of students");
			Arrays.asList(new Integer[] { 0, 1, 2, 3 }).stream()
					.map(i -> new Book("Kirja" + i, "Kirjoittaja" + i, i, "007-" + i, 99.99))
					.forEach(b -> repo.save(b));

			log.info("fetch all books");
			repo.findAll().forEach(b -> log.info(b.toString()));
		};
	}

}
