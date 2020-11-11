package bookshop.boundary;

import java.util.Collection;
import java.util.LinkedList;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import bookshop.entity.Book;
@WebListener
public class BookshopServletContextListener implements ServletContextListener{

    @Override
    public void contextDestroyed(ServletContextEvent event) {
        
    }

       
    @Override
    public void contextInitialized(ServletContextEvent event) {
    	    
        ServletContext sc = event.getServletContext();
        Collection<Book> liste = new LinkedList<Book>();
        liste.add(new Book(1,"Die Schatzinsel","Stevenson",1890));
        liste.add(new Book(2,"FrankenStein","Shelley",1890));
        liste.add(new Book(3,"Shining","Stephen King",1978));
        sc.setAttribute("buchliste", liste);
        System.out.println("++++++++ContextInitialized");
      
        
    }
}
