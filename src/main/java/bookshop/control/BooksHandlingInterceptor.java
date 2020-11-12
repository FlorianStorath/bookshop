package bookshop.control;

import java.io.Serializable;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

import bookshop.entity.Book;

@BooksHandling
@Interceptor
public class BooksHandlingInterceptor implements Serializable{
	private static final long serialVersionUID = 1L;
    public BooksHandlingInterceptor() {
    	
    }
	@AroundInvoke
	public Object aroundInvoke(InvocationContext ic) throws Exception {

		// Suchen nach dem Parameter vom Typ Fahrzeug
		for (Object o : ic.getParameters()) {
			if (o instanceof Book) {
				Book book = (Book) o;
				if (book.getYear() < 1600) {
					throw new IllegalArgumentException("Fahrzeuge mit Baujahr vor 1900 sind nicht zulässig.");
				} else {
					System.out.printf("Buch mit Erscheinungsjahr %d an Methoden '%s' übergeben.%n", book.getYear(),
							ic.getMethod().getName());
				}
			}
		}

		// Aufruf der Original-Methode
		return ic.proceed();

	}
}
