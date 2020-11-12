package bookshop.boundary;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Set;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import bookshop.control.BooksData;
import bookshop.entity.Book;

/**
 * Servlet implementation class BooksCRUDServlet
 */
@WebServlet("/createData")
public class BooksCRUDServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     @Inject
     private BooksData booksData;
     @Inject
 	private Validator validator;
    
    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title = request.getParameter("title");
		String author = request.getParameter("author");
		String idParameter = request.getParameter("id");
		String yearParameter = request.getParameter("year");
		int id;
		int year;
		try {
			id = Integer.parseInt(idParameter);
			year = Integer.parseInt(yearParameter);
		} catch (NumberFormatException e) {
			response.sendError(HttpServletResponse.SC_BAD_REQUEST);
			return;
		}
		Book book = new Book(id,title,author,year);
		Set<ConstraintViolation<Book>> violations = validator.validate(book);
		if(!violations.isEmpty()) {
			// fachlicher Fehler, kein technischer Fehler
			response.setContentType("text/plain");
			try(PrintWriter out = response.getWriter()) {
				out.println("Objekt ist fehlerhaft, konnte nicht eingefügt werden");
				violations.forEach(v -> out.printf(" - %s %s%n", v.getPropertyPath(), v.getMessage()));
			}
			return;
		}
		booksData.add(new Book(id,title,author,year));
		response.sendRedirect("books");
//       try(PrintWriter out = response.getWriter()) {
//			out.println("Datensatz angelegt!");
//				};
	}

}
