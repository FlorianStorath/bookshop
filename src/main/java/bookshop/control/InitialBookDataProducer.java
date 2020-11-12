package bookshop.control;

import java.io.Serializable;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.New;
import javax.enterprise.inject.Produces;
import javax.inject.Named;

import bookshop.entity.Book;

@ApplicationScoped
public class InitialBookDataProducer implements Serializable {
	@Produces 
	@ApplicationScoped
	@Named("booksData")
	public BooksData createInitData(@New BooksData booksData) {
		booksData.getBooks().add(new Book(1,"Frankenstein","Mary Shelley",2010));
		booksData.getBooks().add(new Book(2,"Shining","Stephen King", 2018));
		booksData.getBooks().add(new Book(3,"Funkenmord", "Klüpfel",2020));
		booksData.getBooks().add(new Book(4,"Goldstein","Volker Kutscher",2015));
		return booksData;
	}

}
