package com.iman.bookmanagement.service.initialization.csv;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.apache.log4j.Logger;
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

public class CSVInitializationServiceImpl implements CSVInitializationService {

	private static Logger logger = Logger.getLogger(AuthorServiceImpl.class);
	private ICsvBeanReader csvReader;
	private CsvPreference CSV_TYPE = CsvPreference.EXCEL_NORTH_EUROPE_PREFERENCE;
	private AuthorService authorService;
	
	public CSVInitializationServiceImpl(CsvPreference csvType) {
		this.CSV_TYPE = csvType;
		
		authorService = ServiceRepository.getAuthorService();
	}
	public CSVInitializationServiceImpl() {
		authorService = ServiceRepository.getAuthorService();
	}
		
	public void initialize() {
		
	}

	public void loadBookCSV(String fileName) {
		
	}

	public void loadAutorCSV(String fileName) {

			try {
				csvReader = new CsvBeanReader(new FileReader(fileName),
				        CSV_TYPE);
				
				String[] header = csvReader.getHeader(true);
		
			     
				CellProcessor[] processors = new CellProcessor[] {
			            new NotNull(), // EMAIL
			            new NotNull(), // sureName
			            new NotNull(), // FamilyName
			    };
				Author author = null;
		        while ((author = csvReader.read(Author.class, header, processors)) != null) {
		        	authorService.addAuthor(author);
		        }
				
			} catch (FileNotFoundException e) {
				logger.error("FileNotFound exception"+ e);
			}

			catch (IOException e) {
				logger.error("I/O exception"+ e);
			}
		}
	

	public void loadMagazineCSV(String fileName) {
		
	}

}
