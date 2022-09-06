package bookstore.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String title;
	private String author;
	private int bookYear;
	private String isbn;
	private double price;

	public Book() {
	}

	public Book(String title, String author, int bookYear, String isbn, double price) {
		this.title = title;
		this.author = author;
		this.bookYear = bookYear;
		this.isbn = isbn;
		this.price = price;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public void setYear(int year) {
		this.bookYear = year;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getTitle() {
		return title;
	}

	public String getAuthor() {
		return author;
	}

	public int getYear() {
		return bookYear;
	}

	public String getIsbn() {
		return isbn;
	}

	public double getPrice() {
		return price;
	}

	@Override
	public boolean equals(Object o) {
		return o instanceof Book && this.isbn == ((Book) o).isbn;
	}

	@Override
	public String toString() {
		return String.format("Book{title: %s, author: %s, year: %d, isbn: %s, price: %f}",
				title, author, bookYear, isbn, price);
	}

}
