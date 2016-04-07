package com.iman.bookmanagement.service.book;

import java.util.List;
import java.util.Map;

import com.iman.bookmanagement.model.publishable.Book;
import com.iman.bookmanagement.service.Service;

public interface BookService extends Service{

	
	void addBook(Book book);

	Map<String,Book> getAllBooks();
	
	void addAllBooks(List<Book> books);

	Book getBook(String isbn);

}
