package bookshop.faces;

import java.util.Comparator;
import java.util.Optional;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.annotation.HttpConstraint;
import javax.servlet.annotation.ServletSecurity;

import bookshop.control.BooksData;
import bookshop.entity.Book;

@RequestScoped
@Named("insertBean")
@ServletSecurity(@HttpConstraint(rolesAllowed = { "Admin" }))
public class InsertBean {

	@Inject
	Book book;
	@Inject
	BooksData booksData;
	
	public String insert() { // Bean Validation automatisch
		// ID setzen
		Optional<Integer> max = booksData.getBooks().stream().map(Book::getId).max(Comparator.naturalOrder());
		// Kopie erstellen, da CDI Managed Bean Proxy -> bei Validierung in Interceptor gibt es Probleme
		Book newBook = new Book(max.orElse(0) + 1, book.getTitle(), book.getAuthor(),book.getYear());
		booksData.add(newBook);
		return "anzeige";
	}
	
	
}
