package bookshop.boundary;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bookshop.control.BooksData;
import bookshop.control.Merkliste;
import bookshop.entity.Book;

/**
 * Servlet implementation class WarenKorbServlet
 */
@WebServlet("/merken")
public class WarenKorbServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Inject
	private BooksData booksData;
	@Inject
	private Merkliste merkliste;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WarenKorbServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] ids = request.getParameterValues("id");
		if(null != ids && ids.length>0) {
					
			Set<Integer> idSet = Arrays.stream(ids).map(Integer::valueOf).collect(Collectors.toSet());
			Collection<Book> bestand = booksData.getBooks();
			// alles aus bestand, dessen ID in idSet (=Parameter) zu finden ist, wird in die Merkliste gepackt.
			bestand.stream().filter(f -> idSet.contains(f.getId())).forEach(merkliste.getBooks()::add);
		}
		
		// Anzeige der Merkliste
		response.sendRedirect("merkliste");
	}

}
