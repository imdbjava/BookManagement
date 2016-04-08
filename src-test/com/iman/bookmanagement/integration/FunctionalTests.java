package com.iman.bookmanagement.integration;

import org.junit.Test;
import static org.junit.Assert.*;

import org.junit.Before;

import com.iman.bookmanagement.repository.ServiceRepository;
import com.iman.bookmanagement.service.author.AuthorService;
import com.iman.bookmanagement.service.initialization.csv.CSVInitializationService;
import com.iman.bookmanagement.service.publishment.PublishmentService;

public class FunctionalTests {

	@Before
	public void testLoadAuthorCSV() {
		ServiceRepository serviceRepository = new ServiceRepository();
		String csvFile = "data/autoren.csv";
		CSVInitializationService csvService = ServiceRepository.getCsvInitializationService();
		csvService.loadAutorCSV(csvFile);
		AuthorService authorService  = ServiceRepository.getAuthorService();
		assertNotNull(authorService.getAllAuthors());
		assertEquals(authorService.getAllAuthors().keySet().size(), 6);
	}
	@Test
	public void testLoadBookCSV() {
		CSVInitializationService csvService = ServiceRepository.getCsvInitializationService();
		String csvBook = "data/buecher.csv";
		csvService.loadBookCSV(csvBook);
		PublishmentService service  = ServiceRepository.getPushlishmentService();
		assertNotNull(service.getAllPublishments());
		assertEquals(service.getAllPublishments().keySet().size(), 8);
	}
	
	@Test
	public void testLoadMagazineCSV() {
		CSVInitializationService csvService = ServiceRepository.getCsvInitializationService();
		String csvMagazine = "data/zeitschriften.csv";
		csvService.loadMagazineCSV(csvMagazine);
		PublishmentService service  = ServiceRepository.getPushlishmentService();
		assertNotNull(service.getAllPublishments());
		assertEquals(service.getAllPublishments().keySet().size(), 6);
	}
	
	
	
}
