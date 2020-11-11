package bookshop.boundary;

import java.io.IOException;
import java.util.Collection;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bookshop.control.Merkliste;
import bookshop.entity.Book;

/**
 * Servlet implementation class WarenkorbAnzeigenServlet
 */
@WebServlet("/merkliste")
public class WarenkorbAnzeigenServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Inject
	private Merkliste merkliste; 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WarenkorbAnzeigenServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Logik, z.B. DB-Zugriff o.Ä.

				
				request.setAttribute("books", merkliste.getBooks()); // null ist okay
				request.setAttribute("pageTitle", "Merkliste");
				request.setAttribute("merkenFormDisabled", true);
				request.getRequestDispatcher("/displayData.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	

}
