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
	private int bear;			//bear == bookYear   :-#)#
	private String isbn;
	private double price;

	public Book() {
	}

	public Book(String t, String a, int b, String i, double p) {
		this.title = t;
		this.author = a;
		this.bear = b;
		this.isbn = i;
		this.price = p;
	}

	public void setTitle(String t) {
		this.title = t;
	}

	public void setAuthor(String a) {
		this.author = a;
	}

	public void setBear(int b) {
		this.bear = b;
	}

	public void setIsbn(String i) {
		this.isbn = i;
	}

	public void setPrice(double p) {
		this.price = p;
	}

	public String getTitle() {
		return title;
	}

	public String getAuthor() {
		return author;
	}

	public int getBear() {
		return bear;
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
				title, author, bear, isbn, price);
	}

}
