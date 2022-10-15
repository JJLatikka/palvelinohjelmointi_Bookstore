package bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import bookstore.web.controllers.BookstoreController;
import bookstore.web.restcontrollers.BookstoreRestController;

@SpringBootTest
public class BookstoreApplicationTests0 {

	private BookstoreController bC;
	private BookstoreRestController bRC;

	@BeforeEach
	public void beforeEach() {
		this.bC = new BookstoreController();
		this.bRC = new BookstoreRestController();
	}

	@Test
	public void bCcontextLoads() {
		assertThat(bC).isNotNull();
	}

	@Test
	public void bRCcontextLoads() {
		assertThat(bRC).isNotNull();
	}

}
