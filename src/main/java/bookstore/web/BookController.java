package bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import bookstore.domain.BookRepository;

@Controller
public class BookController {
	
	@Autowired
	private BookRepository repo;

	@RequestMapping("index")
	@ResponseBody
	public String donner() {
		return "Lukeminen kannattaa aina!";
	}
	
	@GetMapping("booklist")
	public String bookList(Model m) {
		m.addAttribute("books", repo.findAll());
		return "bookListTemplate";
	}

}
