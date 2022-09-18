package bookstore.domain;

import java.util.List;

import javax.persistence.CascadeType;
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

	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "category")
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

	@Override
	public String toString() {
		return String.format("Category{name: %s, books in this category: %d}", name, books.size());
	}

}
