package bookstore.web.controllers;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import bookstore.domain.entities.Book;
import bookstore.domain.repositories.BookRepository;
import bookstore.domain.repositories.CategoryRepository;

@Controller
public class BookstoreController {

	@Autowired
	private BookRepository bRepo;

	@Autowired
	private CategoryRepository cRepo;

	private String[] uNames;
	private Long editId;
	private String message;
	private StringBuilder sB;
	private List<String> errorList;
	private Map<String, String> messages;

	public BookstoreController() {
		this.uNames = new String[] { null, null };
		setMessages();
	}

	@GetMapping("/login")
	public String login() {
		return "loginTemplate";
	}

	@GetMapping("/booklist")
	public String bookList(Model m) {
		greetingsToNewUser(getCurrentUsername());
		m.addAttribute("books", bRepo.findAll());
		m.addAttribute("message", message);
		message = null;
		return "bookListTemplate";
	}

	@PreAuthorize("hasAuthority('ADMIN')")
	@GetMapping("/addbook")
	public String addBook(Model m) {
		m.addAttribute("book", new Book());
		m.addAttribute("categories", cRepo.findAll());
		return "addBookTemplate";
	}

	@PreAuthorize("hasAuthority('ADMIN')")
	@PostMapping("/savebook")
	public String saveBook(@Valid Book b, BindingResult bR) {
		if (editId != null) {
			b.setId(editId);
			editId = null;
		}
		if (!bR.hasErrors()) {
			bRepo.save(b);
		} else {
			message = getMessage(bR);
		}
		return "redirect:/booklist";
	}

	@PreAuthorize("hasAuthority('ADMIN')")
	@GetMapping("/deletebook/{id}")
	public String deleteBook(@PathVariable("id") Long id) {
		bRepo.deleteById(id);
		return "redirect:/booklist";
	}

	@PreAuthorize("hasAuthority('ADMIN')")
	@GetMapping("/editbook/{id}")
	public String editBook(@PathVariable("id") Long id, Model m) {
		m.addAttribute("book", bRepo.findById(id).get());
		m.addAttribute("categories", cRepo.findAll());
		editId = id;
		return "addBookTemplate";
	}

	private String getCurrentUsername() {
		return SecurityContextHolder.getContext().getAuthentication().getName();
	}

	private void greetingsToNewUser(String n) {
		uNames[0] = n;
		if (!Objects.equals(uNames[0], uNames[1])) {
			uNames[1] = n;
			message = String.format("Welcome, %s!", n);
		}
	}

	private void setMessages() {
		this.messages = Arrays
				.asList(new String[][] { { "NotEmpty", "Title, Author and ISBN cannot be empty." },
						{ "NotNull", "Year and Price cannot be empty." },
						{ "typeMismatch", "Year and Price must contain only numeric values." } })
				.stream().collect(Collectors.toMap(l -> l[0], l -> l[1]));
	}

	private String getMessage(BindingResult bR) {
		sB = new StringBuilder();
		errorList = bR.getAllErrors().stream().map(e -> e.toString()).toList();
		sB.append("Please, fill all the required information.");
		sB.append(matches("NotEmpty") ? "\n" + messages.get("NotEmpty") : "");
		sB.append(matches("NotNull") ? "\n" + messages.get("NotNull") : "");
		sB.append(matches("typeMismatch") ? "\n" + messages.get("typeMismatch") : "");
		return sB.toString();
	}

	private boolean matches(String s) {
		return errorList.stream().anyMatch(e -> e.contains(s));
	}

	public void setErrorMessage(String m) {
		message = m;
	}

}
