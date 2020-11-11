package bookshop.control;

import java.io.Serializable;
import java.util.Collection;
import java.util.Comparator;
import java.util.TreeSet;

import javax.enterprise.context.SessionScoped;

import bookshop.entity.Book;

@SessionScoped
public class Merkliste implements Serializable {

	private static final long serialVersionUID = 1L;

	private final Collection<Book> fahrzeuge = new TreeSet<>(Comparator.comparing(Book::getId));

	public Collection<Book> getBooks() {
		return fahrzeuge;
	}
	
}
