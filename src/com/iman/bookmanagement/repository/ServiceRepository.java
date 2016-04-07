package com.iman.bookmanagement.repository;

import com.iman.bookmanagement.service.Magazine.MagazineService;
import com.iman.bookmanagement.service.Magazine.MagazineServiceImpl;
import com.iman.bookmanagement.service.author.AuthorService;
import com.iman.bookmanagement.service.author.AuthorServiceImpl;
import com.iman.bookmanagement.service.book.BookService;
import com.iman.bookmanagement.service.book.BookServiceImpl;
import com.iman.bookmanagement.service.initialization.csv.CSVInitializationService;
import com.iman.bookmanagement.service.initialization.csv.CSVInitializationServiceImpl;

public class ServiceRepository {

	public static AuthorService authorService;
	public static BookService bookService;
	public static MagazineService magazineService;
	public static CSVInitializationService csvInitializationService;
	
	public ServiceRepository() {
		authorService = new AuthorServiceImpl();
		bookService = new BookServiceImpl();
		magazineService = new MagazineServiceImpl();
		csvInitializationService = new CSVInitializationServiceImpl();
	}

	public static CSVInitializationService getCsvInitializationService() {
		return csvInitializationService;
	}

	public static AuthorService getAuthorService() {
		return authorService;
	}

	public static BookService getBookService() {
		return bookService;
	}

	public static MagazineService getMagazineService() {
		return magazineService;
	}
	


}
