package bookstore.domain.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String title;
	private String author;
	@Column(name = "book_year")
	private int year;
	private String isbn;
	private double price;

	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;

	public Book() {
	}

	public Book(String t, String a, int y, String i, double p, Category c) {
		this.title = t;
		this.author = a;
		this.year = y;
		this.isbn = i;
		this.price = p;
		this.category = c;
	}

	public Long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getAuthor() {
		return author;
	}

	public Category getCategory() {
		return category;
	}

	public int getYear() {
		return year;
	}

	public String getIsbn() {
		return isbn;
	}

	public double getPrice() {
		return price;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setTitle(String t) {
		this.title = t;
	}

	public void setAuthor(String a) {
		this.author = a;
	}

	public void setCategory(Category c) {
		this.category = c;
	}

	public void setYear(int y) {
		this.year = y;
	}

	public void setIsbn(String i) {
		this.isbn = i;
	}

	public void setPrice(double p) {
		this.price = p;
	}

	@Override
	public boolean equals(Object o) {
		return o instanceof Book && this.isbn == ((Book) o).isbn;
	}

	@Override
	public String toString() {
		String s = "Book{ title: %s, author: %s, year: %d, isbn: %s, price: %f%s }";
		String c = category != null ? String.format(",\ncategory: %s", category) : "";
		return String.format(s, title, author, year, isbn, price, c);
	}

}
