package com.iman.bookmanagement.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.junit.Before;
import org.junit.Test;

import com.iman.bookmanagement.model.persons.Author;
import com.iman.bookmanagement.model.publishable.Book;
import com.iman.bookmanagement.model.publishable.Magazine;
import com.iman.bookmanagement.model.publishable.Publishment;
import com.iman.bookmanagement.repository.ServiceRepository;

public class ModelTests {

	@Before
	public void intialize() {
		ServiceRepository serviceRepository = new ServiceRepository();
	}
	/** we want to write a test for converting csv to pojos.*/
	@Test
	public void createPojosTest() {
		// we need a list autors to be filled
		List<Author> autors = new ArrayList<Author>(); 
		Author autor = new Author("iman@java.de","Iman","Db");
		autors.add(autor);
		assertNotNull(autors);
		assertEquals(autors.get(0), autor);
		assertNotNull(autor);
		assertEquals(autor.getEmailAddress(), "iman@java.de");
		assertNotNull(autor.getFamilyName());
		assertNotNull(autor.getSureName());
		// we also need some books and magazines. namely publishables
		String isbn = "1-56619-909-3";
		// TODO check ISBN validation.
		Book book= new Book("book title","email3@test.de",isbn,"short desc");
		assertNotNull(book.getShortDescription());
		assertNotNull(book.getIsbn());
		assertNotNull(book.getTitle());
		assertNotNull(book.getAutors());
		
		String date = "2015-10-10";
		
		Magazine magazine = new Magazine("magazine title","mag@test.de",isbn, date);
		assertNotNull(magazine.getAutors());
		assertNotNull(magazine.getTitle());
		assertNotNull(magazine.getIsbn());
		assertNotNull(magazine.getPublishDate());

	}

}
