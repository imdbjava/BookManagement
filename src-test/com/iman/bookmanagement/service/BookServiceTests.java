package com.iman.bookmanagement.service;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import static org.junit.Assert.*;

import com.iman.bookmanagement.model.persons.Author;
import com.iman.bookmanagement.model.publishable.Book;
import com.iman.bookmanagement.service.author.AuthorService;
import com.iman.bookmanagement.service.author.AuthorServiceImpl;
import com.iman.bookmanagement.service.book.BookService;
import com.iman.bookmanagement.service.book.BookServiceImpl;

public class BookServiceTests {


	@Test
	public void addAndGetBookTest(){
		AuthorService autorService = new AuthorServiceImpl();
		Author author = new Author("iman@java.de","Iman","Db");
		autorService.addAuthor(author);
		assertNotNull(autorService.getAuthor(author.getEmailadresse()));
		List<Author> authors = new ArrayList<Author>();
		authors.add(author);

		BookService bookService = new BookServiceImpl();
		String isbn = "1-56619-909-3";
		// TODO check ISBN validation.
		Book book= new Book("book title",authors,isbn,"short desc");
		bookService.addBook(book);
		assertNotNull(bookService.getBook(isbn));
	}
	@Test
	public void addAllAndGetAllBooksTest(){
		AuthorService autorService = new AuthorServiceImpl();
		Author author = new Author("iman@java.de","Iman","Db");
		autorService.addAuthor(author);
		assertNotNull(autorService.getAuthor(author.getEmailadresse()));
		List<Author> authors = new ArrayList<Author>();
		authors.add(author);

		BookService bookService = new BookServiceImpl();
		String isbn1 = "1-56619-909-3";
		String isbn2 = "2-56619-909-4";
		
		// TODO check ISBN validation.
		Book book1= new Book("book title1",authors,isbn1,"short desc 1");
		Book book2= new Book("book title2",authors,isbn2,"short desc 2");
		List<Book> books= new ArrayList<Book>();
		books.add(book1);
		books.add(book2);
		
		bookService.addAllBooks(books);
		assertNotNull(bookService.getAllBooks());
		
		for(Book book:books) {
			assertNotNull(bookService.getBook(book.getIsbn()));
		}
	}
}
