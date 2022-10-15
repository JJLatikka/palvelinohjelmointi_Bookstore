package bookstore;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import bookstore.domain.entities.Book;
import bookstore.domain.repositories.BookRepository;

@SpringBootTest
public class BookstoreApplicationTests1 {

	@Autowired
	private BookRepository bRepo;

	private List<Book> bL = Arrays.asList(new String[] { "Test0", "Test1", "Test2", "Test3" }).stream()
			.map(s -> new Book(s, s, Integer.valueOf(-1), s, Double.valueOf(-1), null)).toList();

	@BeforeEach
	public void beforeEach() {
		bRepo.deleteAll();
	}

	@Test
	public void saveBookTest() {
		bRepo.save(bL.get(0));
		assertThat(bRepo.findByTitle("Test0")).isNotNull();
	}

	@Test
	public void deleteBookTest() {
		Long id = bRepo.save(bL.get(0)).getId();
		bRepo.deleteById(id);
		assertThat(bRepo.findByTitle("Test0")).isNull();
	}

	@Test
	public void findOneBookTest() {
		Long id = bRepo.save(bL.get(0)).getId();
		assertThat(bRepo.findById(id).isPresent());
	}

	@Test
	public void findAllBooks() {
		bL.forEach(bRepo::save);
		List<Book> l = new ArrayList<>();
		bRepo.findAll().forEach(l::add);
		assertEquals(l.size(), 4);
	}

}
