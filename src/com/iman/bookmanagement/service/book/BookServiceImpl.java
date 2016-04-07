package com.iman.bookmanagement.service.book;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import com.iman.bookmanagement.model.publishable.Book;

public class BookServiceImpl implements BookService {
	
	private static Logger logger = Logger.getLogger(BookServiceImpl.class);

     Map<String,Book> books;
	
	public BookServiceImpl() {
		books = new HashMap<String, Book>();
		BasicConfigurator.configure();
	}
	
	public void addBook(Book book) {
		if(book!= null && ! books.containsKey(book.getIsbn())) {
			books.put(book.getIsbn(), book);
		} else {
			logger.error("Book already exists or the parameter was null");

		}
		
	}

	public Book getBook(String isbn) {
		if(isbn!= null && isbn.trim() != "") {
			if(books.containsKey(isbn)) {
			return books.get(isbn);
			} else {
				logger.error("book not found.");
			}
		}else  {
			logger.error("isbn parameter was null or empty");
		}
			return null;	
			
	}

	public void addAllBooks(List<Book> books) {
		if(books != null) {
		for(Book book:books) {
			addBook(book);
		}
		} else {
			logger.error("books argument was null");
		}
		
	}

	public Map<String,Book> getAllBooks() {
		return books;
	}

}
