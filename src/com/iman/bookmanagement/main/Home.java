package com.iman.bookmanagement.main;

import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map.Entry;

import com.iman.bookmanagement.model.persons.Author;
import com.iman.bookmanagement.model.publishable.Book;
import com.iman.bookmanagement.model.publishable.Magazine;
import com.iman.bookmanagement.model.publishable.Publishment;
import com.iman.bookmanagement.repository.ServiceRepository;
import com.iman.bookmanagement.service.Magazine.MagazineService;
import com.iman.bookmanagement.service.author.AuthorService;
import com.iman.bookmanagement.service.book.BookService;
import com.iman.bookmanagement.service.initialization.csv.CSVInitializationService;
import com.iman.bookmanagement.service.initialization.csv.CSVInitializationServiceImpl;
import com.iman.bookmanagement.service.publishment.PublishmentService;
import com.iman.bookmanagement.service.publishment.PublishmentServiceImpl;

public class Home {

	public static void main(String[] args) throws UnsupportedEncodingException {
		
		// First we initialize the service repository
		ServiceRepository serviceRepository = new ServiceRepository();
		// defining files
		String authorFile = "/home/iman/Dropbox/Learn/BookManagement/data/autoren.csv";
		String bookFile = "/home/iman/Dropbox/Learn/BookManagement/data/buecher.csv";
		String magazineFile = "/home/iman/Dropbox/Learn/BookManagement/data/zeitschriften.csv";
	
		PrintStream out = new PrintStream(System.out, true, "UTF-8");
		
		// initializing services
		CSVInitializationService csvService = ServiceRepository.getCsvInitializationService();
		AuthorService autorService = ServiceRepository.getAuthorService();
		PublishmentService publishmentService = ServiceRepository.getPushlishmentService();
		// load all the authors.
		csvService.loadAutorCSV(authorFile);
		
		// load all the books
		csvService.loadBookCSV(bookFile);
		
		// load all the magazines 
		csvService.loadMagazineCSV(magazineFile);
		
		
		out.println("\n\nprint all the books and magazines ");
		for(Entry<String,Publishment> entry :ServiceRepository.getPushlishmentService().getAllPublishments().entrySet()) {
			out.println(entry.getValue());	
			}
		
		
		out.print("\n \nsearch for the book with ISBN 5554-5545-4518:\n");
		String isbn = "5554-5545-4518";
		out.println(publishmentService.getPublishment(isbn));
		
		// find publishments by author. we can search 
		// with family name and surname
		List<Author> authors = autorService.findAuthorByNameAndFamilyName("Paul", "Walter");
		for(Author author :authors) {
			out.println("these are the founded publications for "+ author+":");
			out.println("\n");
			List<Publishment> publishments = publishmentService.findPublishmentsByAuthor(author.getEmailAddress());
			for(Publishment publishment: publishments)
			     out.println(publishment+ "\n");
		}
		
		
		
	}
}
