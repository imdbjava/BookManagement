package com.iman.bookmanagement.repository;

import com.iman.bookmanagement.service.Magazine.MagazineService;
import com.iman.bookmanagement.service.Magazine.MagazineServiceImpl;
import com.iman.bookmanagement.service.author.AuthorService;
import com.iman.bookmanagement.service.author.AuthorServiceImpl;
import com.iman.bookmanagement.service.book.BookService;
import com.iman.bookmanagement.service.book.BookServiceImpl;
import com.iman.bookmanagement.service.initialization.csv.CSVInitializationService;
import com.iman.bookmanagement.service.initialization.csv.CSVInitializationServiceImpl;
import com.iman.bookmanagement.service.publishment.PublishmentService;
import com.iman.bookmanagement.service.publishment.PublishmentServiceImpl;

public class ServiceRepository {

	private static AuthorService authorService;
	private static BookService bookService;
	private static MagazineService magazineService;
	private static CSVInitializationService csvInitializationService;
	private static PublishmentService publishmentService;
	
	public ServiceRepository() {
		publishmentService = new PublishmentServiceImpl();
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

	public static PublishmentService getPushlishmentService() {
		return publishmentService;
	}
	


}
