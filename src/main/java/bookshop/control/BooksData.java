package bookshop.control;

import java.util.Collection;
import java.util.LinkedList;

import bookshop.entity.Book;

public class BooksData {
	private static final BooksData theInstance = new BooksData();

	private final Collection<Book> books = new LinkedList<>();

	// nur 1 Bestand in der Anwendung -> Singleton

	private BooksData() {
		books.add(new Book("Frankenstein","Mary Shelley",2010));
		books.add(new Book("Shining","Stephen King", 2018));
		books.add(new Book("Funkenmord", "Klüpfel",2020));
		books.add(new Book("Goldstein","Volker Kutscher",2015));
	}

	public Collection<Book> getBooks() {
		return books;
	}

	public boolean add(Book book) {
		return books.add(book);
	}

	public boolean remove(Book o) {
		return books.remove(o);
	}

	public static BooksData getInstance() {
		return theInstance;
	}
}
