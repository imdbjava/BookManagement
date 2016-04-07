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
import com.iman.bookmanagement.model.publishable.Book;
import com.iman.bookmanagement.model.publishable.Magazine;
import com.iman.bookmanagement.repository.ServiceRepository;
import com.iman.bookmanagement.service.Magazine.MagazineService;
import com.iman.bookmanagement.service.author.AuthorService;
import com.iman.bookmanagement.service.author.AuthorServiceImpl;
import com.iman.bookmanagement.service.book.BookService;

public class CSVInitializationServiceImpl implements CSVInitializationService {

	private static Logger logger = Logger.getLogger(AuthorServiceImpl.class);
	private ICsvBeanReader csvReader;
	private CsvPreference CSV_TYPE = CsvPreference.EXCEL_NORTH_EUROPE_PREFERENCE;
	private AuthorService authorService;
	private BookService bookService;
	private MagazineService magazineService;
	
	public CSVInitializationServiceImpl(CsvPreference csvType) {
		this.CSV_TYPE = csvType;
		
		authorService = ServiceRepository.getAuthorService();
		magazineService = ServiceRepository.getMagazineService();
		bookService = ServiceRepository.getBookService();
		
	}
	public CSVInitializationServiceImpl() {
		authorService = ServiceRepository.getAuthorService();
		magazineService = ServiceRepository.getMagazineService();
		bookService = ServiceRepository.getBookService();
	}
		
	public void initialize() {
		
	}

	public void loadBookCSV(String fileName) {
		try {
			csvReader = new CsvBeanReader(new FileReader(fileName),
			        CSV_TYPE);
			
			csvReader.getHeader(false);
			String[] header = {"title", "iSBN","autors", "shortDescription"};
		     
			CellProcessor[] processors = new CellProcessor[] {
		            new NotNull(), // Titel
		            new NotNull(), // ISBN-Nummer
		            new NotNull(), // Autoren
		            new NotNull(), // Kurzbeschreibung
		            
		    };
			Book book = null;
	        while ((book = csvReader.read(Book.class, header, processors)) != null) {
	        	bookService.addBook(book);
	        }
			
		} catch (FileNotFoundException e) {
			logger.error("FileNotFound exception"+ e);
		}

		catch (IOException e) {
			logger.error("I/O exception"+ e);
		}
	}

	

	public void loadAutorCSV(String fileName) {

			try {
				csvReader = new CsvBeanReader(new FileReader(fileName),
				        CSV_TYPE);
				
				
				csvReader.getHeader(false);
				String[] header= {"emailAddress", "sureName", "familyName"};
			     
				CellProcessor[] processors = new CellProcessor[] {
			            new NotNull(), // EMAIL
			            new NotNull(), // sureName
			            new NotNull(), // FamilyName
			    };
				Author author = null;
		        while ((author = csvReader.read(Author.class, header , processors)) != null) {
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
		try {
			csvReader = new CsvBeanReader(new FileReader(fileName),
			        CSV_TYPE);
			
			 csvReader.getHeader(false);
	
			String[] header = {"title", "iSBN","autors", "publishDate"};

				
			CellProcessor[] processors = new CellProcessor[] {
		            new NotNull(), // Titel
		            new NotNull(), // ISBN-Nummer
		            new NotNull(), // Autoren
		            new NotNull(), // Datum
		            
		    };
			Magazine magazine = null;
	        while ((magazine = csvReader.read(Magazine.class, header, processors)) != null) {
	        	magazineService.addMagazine(magazine);
	        }
			
		} catch (FileNotFoundException e) {
			logger.error("FileNotFound exception"+ e);
		}

		catch (IOException e) {
			logger.error("I/O exception"+ e);
		}

	}

}
