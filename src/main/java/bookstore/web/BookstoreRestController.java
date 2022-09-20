package bookstore.web;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import bookstore.domain.Book;
import bookstore.domain.BookRepository;
import bookstore.domain.Category;
import bookstore.domain.CategoryRepository;

@RestController
public class BookstoreRestController {

	@Autowired
	private BookRepository repo;
	@Autowired
	private CategoryRepository repolainen;

	@GetMapping("/books")
	public Iterable<Book> bookListRest() {
		return repo.findAll();
	}

	@GetMapping("/book/{id}")
	public Optional<Book> findBookRest(@PathVariable("id") Long id) {
		return repo.findById(id);
	}

	@GetMapping("/categories")
	public Iterable<Category> categoryList() {
		return repolainen.findAll();
	}

	@GetMapping("/category/{id}")
	public Optional<Category> findCategoryRest(@PathVariable("id") Long id) {
		return repolainen.findById(id);
	}

}
