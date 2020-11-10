package bookshop.boundary;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import bookshop.control.BooksData;
import bookshop.entity.Book;

/**
 * Servlet implementation class BooksCRUDServlet
 */
@WebServlet("/createData")
public class BooksCRUDServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title = request.getParameter("title");
		String author = request.getParameter("author");
		int id = Integer.parseInt(request.getParameter("id"));
		int year = Integer.parseInt(request.getParameter("year"));
		BooksData.getInstance().add(new Book(id,title,author,year));
		//response.sendRedirect("http://localhost:8080/sample-0.0.1-SNAPSHOT/books");
//       try(PrintWriter out = response.getWriter()) {
//			out.println("Datensatz angelegt!");
//				};
	}

}
