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
import bookstore.domain.Category;
import bookstore.domain.CategoryRepository;

@SpringBootApplication
public class BookstoreApplication {

	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {

		SpringApplication.run(BookstoreApplication.class, args);

	}

	@Bean
	public CommandLineRunner bookstoreDemo(BookRepository repo, CategoryRepository repolainen) {

		return (args) -> {

			log.info("save a couple of students and a few categories");
			Arrays.asList(
					new String[] { "Kirjaston kirja", "Hyvä", "Parempi", "Paras", "Huono", "Huonompi", "Huonoin" })
					.forEach(s -> repolainen.save(new Category(s)));

			Category cat = repolainen.findByName("Kirjaston kirja").get(0);

			Arrays.asList(new Integer[] { 0, 1, 2, 3 }).stream()
					.map(i -> new Book("Kirja" + i, "Kirjoittaja" + i, i, "007-" + i, 99.99, cat))
					.forEach(b -> repo.save(b));

			log.info("fetch all books");
			repo.findAll().forEach(b -> System.out.println(String.format("\n%s\n", b)));

			log.info("fetch all categories");
			repolainen.findAll().forEach(c -> System.out.println(String.format("\n%s\n", c)));

		};

	}

}
