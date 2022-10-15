package bookstore;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import bookstore.domain.entities.AppUser;
import bookstore.domain.entities.Book;
import bookstore.domain.entities.Category;
import bookstore.domain.repositories.AppUserRepository;
import bookstore.domain.repositories.BookRepository;
import bookstore.domain.repositories.CategoryRepository;
import bookstore.web.controllers.BookstoreController;

@SpringBootApplication
public class BookstoreApplication {

	private BookstoreController bC = new BookstoreController();
	private REEH rEEH = new REEH(bC);

	public static void main(String[] args) {

		SpringApplication.run(BookstoreApplication.class, args);

	}

	@Bean
	public CommandLineRunner bookstoreDemo(BookRepository bRepo, CategoryRepository cRepo, AppUserRepository aURepo) {

		return (args) -> {

			aURepo.save(new AppUser("user", "$2a$10$bfbIcvOfWnN0XN.HkZAeN.FwNpZdFcQ5SxnVuXmjpl35e7qYU7TTu", "USER"));
			aURepo.save(new AppUser("admin", "$2a$10$2JEr/FAUOR8gLaGtBlbcNuh0X9vc8smzjjCKKMkE5.dhS5kdDBfOm", "ADMIN"));

			Arrays.asList(
					new String[] { "Kirjaston kirja", "Hyvä", "Parempi", "Paras", "Huono", "Huonompi", "Huonoin" })
					.stream().map(s -> new Category(s)).forEach(cRepo::save);

			Category cat = cRepo.findByName("Kirjaston kirja");

			Arrays.asList(new Integer[] { 0, 1, 2, 3 }).stream()
					.map(i -> new Book("Kirja" + i, "Kirjoittaja" + i, i, "007-" + i, 99.99, cat)).forEach(bRepo::save);

			System.out.println("\nLuotiin muutama kategoria ja kirja ja kayttaja.\n");

			bRepo.findAll().forEach(b -> System.out.println(String.format("\n%s\n", b)));

			cRepo.findAll().forEach(c -> System.out.println(String.format("\n%s\n", c)));

			aURepo.findAll().forEach(aU -> System.out.println(String.format("\n%s\n", aU)));

		};

	}

}
