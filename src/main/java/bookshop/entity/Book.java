package bookshop.entity;

import java.io.Serializable;

public class Book implements Serializable {
	private String title;
	private String author;
	private int year;
	private int id;
	public Book(int id,String title, String author, int year) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.year = year;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
