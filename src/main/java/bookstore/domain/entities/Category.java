package bookstore.domain.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private long booksInThisCategory;

	@JsonIgnore
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "category")
	private List<Book> books;

	public Category() {
	}

	public Category(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Book> getBooks() {
		return books;
	}

	public long getBooksInThisCategory() {
		setBooksInThisCategory();
		return booksInThisCategory;
	}

	public void setBooksInThisCategory() {
		this.booksInThisCategory = books.size();
	}

	@Override
	public String toString() {
		return String.format("Category{ name: %s, books in this category: %d }", name, getBooksInThisCategory());
	}

}
