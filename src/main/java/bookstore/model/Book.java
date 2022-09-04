package bookstore.model;

public class Book {
	
	private String title;
	private String author;
	private int year;
	private String isbn;
	private double price;
	
	public Book() {}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public void setYear(int year) {
		this.year = year;
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
		return year;
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
		return String.format("Book{title: %s, author: %s, year: %d, isbn: %s, price: %f}");
	}
}
