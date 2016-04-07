package com.iman.bookmanagement.integration;

import org.junit.Test;
import static org.junit.Assert.*;

import com.iman.bookmanagement.repository.ServiceRepository;
import com.iman.bookmanagement.service.author.AuthorService;
import com.iman.bookmanagement.service.initialization.csv.CSVInitializationService;
import com.iman.bookmanagement.service.initialization.csv.CSVInitializationServiceImpl;

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
}
