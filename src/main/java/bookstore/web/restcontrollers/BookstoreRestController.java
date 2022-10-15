package bookstore.web.restcontrollers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import bookstore.domain.entities.Book;
import bookstore.domain.entities.Category;
import bookstore.domain.repositories.BookRepository;
import bookstore.domain.repositories.CategoryRepository;

@RestController
public class BookstoreRestController {

	@Autowired
	private BookRepository bRepo;
	@Autowired
	private CategoryRepository cRepo;

	@GetMapping("/books")
	public Iterable<Book> bookListRest() {
		return bRepo.findAll();
	}

	@GetMapping("/books/{id}")
	public Optional<Book> findBookRest(@PathVariable("id") Long id) {
		return bRepo.findById(id);
	}

	@GetMapping("/categories")
	public Iterable<Category> categoryList() {
		return cRepo.findAll();
	}

	@GetMapping("/categories/{id}")
	public Optional<Category> findCategoryRest(@PathVariable("id") Long id) {
		return cRepo.findById(id);
	}

}
