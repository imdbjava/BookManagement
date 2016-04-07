package com.iman.bookmanagement.integration;

import org.junit.Test;
import static org.junit.Assert.*;

import com.iman.bookmanagement.repository.ServiceRepository;
import com.iman.bookmanagement.service.Magazine.MagazineService;
import com.iman.bookmanagement.service.author.AuthorService;
import com.iman.bookmanagement.service.book.BookService;
import com.iman.bookmanagement.service.initialization.csv.CSVInitializationService;
import com.iman.bookmanagement.service.publishment.PublishmentService;

public class FunctionalTests {

	@Test
	public void testLoadAuthorCSV() {
		String csvFile = "/home/iman/Dropbox/Learn/BookManagement/data/autoren.csv";
		ServiceRepository serviceRepository = new ServiceRepository();
		CSVInitializationService csvService = ServiceRepository.getCsvInitializationService();
		csvService.loadAutorCSV(csvFile);
		AuthorService authorService  = ServiceRepository.getAuthorService();
		assertNotNull(authorService.getAllAuthors());
		assertEquals(authorService.getAllAuthors().keySet().size(), 6);
	}
	@Test
	public void testLoadBookCSV() {
		ServiceRepository serviceRepository = new ServiceRepository();
		CSVInitializationService csvService = ServiceRepository.getCsvInitializationService();

		String csvBook = "/home/iman/Dropbox/Learn/BookManagement/data/buecher.csv";
		csvService.loadBookCSV(csvBook);
		PublishmentService service  = ServiceRepository.getPushlishmentService();
		assertNotNull(service.getAllPublishments());
		assertEquals(service.getAllPublishments().keySet().size(), 8);
	}
	
	@Test
	public void testLoadMagazineCSV() {
		ServiceRepository serviceRepository = new ServiceRepository();
		CSVInitializationService csvService = ServiceRepository.getCsvInitializationService();

		String csvMagazine = "/home/iman/Dropbox/Learn/BookManagement/data/zeitschriften.csv";
		csvService.loadMagazineCSV(csvMagazine);
		PublishmentService service  = ServiceRepository.getPushlishmentService();
		assertNotNull(service.getAllPublishments());
		assertEquals(service.getAllPublishments().keySet().size(), 6);
	}
	
	
	
}
