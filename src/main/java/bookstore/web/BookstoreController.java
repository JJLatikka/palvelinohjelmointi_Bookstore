package bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import bookstore.domain.Book;
import bookstore.domain.BookRepository;
import bookstore.domain.CategoryRepository;

@Controller
public class BookstoreController {

	@Autowired
	private BookRepository repo;
	@Autowired
	private CategoryRepository repolainen;
	private Long editId;

	@RequestMapping("index")
	@ResponseBody
	public String donner() {
		return "Lukeminen kannattaa aina!";
	}

	@GetMapping("/booklist")
	public String bookList(Model m) {
		m.addAttribute("books", repo.findAll());
		return "bookListTemplate";
	}

	@GetMapping("/addbook")
	public String addBook(Model m) {
		m.addAttribute("book", new Book());
		m.addAttribute("categories", repolainen.findAll());
		return "addBookTemplate";
	}

	@PostMapping("/savebook")
	public String saveBook(Book b) {
		if (editId != null) {
			repo.deleteById(editId);
			editId = null;
		}
		repo.save(b);
		return "redirect:/booklist";
	}

	@GetMapping("/deletebook/{id}")
	public String deleteBook(@PathVariable("id") Long id) {
		repo.deleteById(id);
		return "redirect:../booklist";
	}

	@GetMapping("/editbook/{id}")
	public String editBook(@PathVariable("id") Long id, Model m) {
		m.addAttribute("book", repo.findById(id).get());
		m.addAttribute("categories", repolainen.findAll());
		editId = id;
		return "addBookTemplate";
	}

}
