package bookshop.boundary;

import java.io.IOException;
import java.util.Collection;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bookshop.control.BooksData;
import bookshop.entity.Book;

/**
 * Servlet implementation class BookshopServlet
 */
@WebServlet("/books")
public class BooksDisplayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Inject
	private BooksData booksData;
@Override     
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		request.setAttribute("books", booksData.getBooks());
		request.setAttribute("pageTitle", "Anzeige aller Bücher");
		request.getRequestDispatcher("/displayData.jsp")
			.forward(request, response);
		
	}

}
