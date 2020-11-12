package bookshop.entity;

import java.io.Serializable;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class Book implements Serializable {
	@Pattern(regexp="[A-Z]")
	@Size(min=1, max=25, message="Wert muss zwischen {min} und {max} Zeichen lang sein.")
	private String title;
	@Pattern(regexp="[A-Z].* [A-Z].*")
	@Size(min=1, max=25, message="Wert muss zwischen {min} und {max} Zeichen lang sein.")
	private String author;
	@Max(2020)
	@Min(1000)
	private int year;
	@NotNull
	@Min(1)
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
