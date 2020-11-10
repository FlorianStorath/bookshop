package bookshop.boundary;

import java.io.IOException;
import java.util.Collection;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bookshop.control.BooksData;
import bookshop.entity.Book;
import sample.Fahrzeug;

/**
 * Servlet implementation class BooksSearchServlet
 */
@WebServlet("/booksearch")
public class BooksSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String suchtext = request.getParameter("suchtext");
		if (null == suchtext) {
			response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Parameter suchtext must not be null!");

		} else {

			// Logik, z.B. DB-Zugriff o.Ä.

			Collection<Book> books = BooksData.getInstance().getBooks();
			Collection<Book> suchErgebnisse = books.stream()
					.filter(fz -> fz.getAuthor().toLowerCase().contains(suchtext.toLowerCase()))
					.collect(Collectors.toList());
			request.setAttribute("books", suchErgebnisse);
			request.getRequestDispatcher("/searchresponse.jsp").forward(request, response);
		}

	}


}
