package com.iman.bookmanagement.service;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.junit.Before;
import org.junit.Test;
import org.supercsv.cellprocessor.constraint.NotNull;
import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.io.CsvBeanReader;
import org.supercsv.io.ICsvBeanReader;
import org.supercsv.prefs.CsvPreference;

import com.iman.bookmanagement.model.persons.Author;
import com.iman.bookmanagement.repository.ServiceRepository;
import com.iman.bookmanagement.service.author.AuthorService;
import com.iman.bookmanagement.service.author.AuthorServiceImpl;
import com.iman.bookmanagement.service.initialization.csv.CSVInitializationService;
import com.iman.bookmanagement.service.initialization.csv.CSVInitializationServiceImpl;

public class CSVInitServiceTests {
	@Before
	public void intialize() {
		ServiceRepository serviceRepository = new ServiceRepository();
	}

	@Test 
	public void loadAuthorsTest() {
		String csvFile = "data/autoren.csv";
		  
		CSVInitializationService csvService = ServiceRepository.getCsvInitializationService();
		csvService.loadAutorCSV(csvFile);
		AuthorService authorService = ServiceRepository.getAuthorService();
		assertNotNull(authorService.getAllAuthors());
		assertEquals(6, authorService.getAllAuthors().keySet().size());
	}
	@Test
	public void loadManuelAuthorsTest() {
		String csvFile = "data/autoren.csv";
	    ICsvBeanReader csvReader;
		try {
			csvReader = new CsvBeanReader(new FileReader(csvFile),
			        CsvPreference.EXCEL_NORTH_EUROPE_PREFERENCE);
			
			 csvReader.getHeader(false);
			String[] header= {"emailAddress", "sureName", "familyName"};

			
			assertNotNull(header);
			assertTrue(header.length>0);
			
			AuthorService authorService = ServiceRepository.getAuthorService();
			CellProcessor[] processors = new CellProcessor[] {
		            new NotNull(), // EMAIL
		            new NotNull(), // sureName
		            new NotNull(), // FamilyName
		    };
			Author author = null;
	        while ((author = csvReader.read(Author.class, header, processors)) != null) {
	        	authorService.addAuthor(author);
				assertNotNull(authorService.getAuthor(author.getEmailAddress()));
	        }
			
		} catch (FileNotFoundException e) {
			fail("FileNotFound exception"+ e);
		}

		catch (IOException e) {
			fail("I/O exception"+ e);
		}
	}

	
}
