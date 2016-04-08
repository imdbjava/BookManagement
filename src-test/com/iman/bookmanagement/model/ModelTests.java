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
		List<Author> authors = new ArrayList<Author>(); 
		Author author = new Author("iman@java.de","Iman","Db");
		authors.add(author);
		assertNotNull(authors);
		assertEquals(authors.get(0), author);
		assertNotNull(author);
		assertEquals(author.getEmailAddress(), "iman@java.de");
		assertNotNull(author.getFamilyName());
		assertNotNull(author.getSureName());
		// we also need some books and magazines. namely publishables
		String isbn = "1-56619-909-3";
		// TODO check ISBN validation.
		Book book= new Book("book title",authors,isbn,"short desc");
		assertNotNull(book.getShortDescription());
		assertNotNull(book.getIsbn());
		assertNotNull(book.getTitle());
		assertNotNull(book.getAutors());
		
		String dateString = "2015-10-10";
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.GERMANY);
		Date date = null;
		try {
			date = format.parse(dateString);
		} catch (ParseException e) {
			fail("Date format Parse Exceptoin"+ e);
		}
	    assertNotNull(date);
	    
		Magazine magazine = new Magazine("magazine title",authors,isbn, date);
		assertNotNull(magazine.getAutors());
		assertNotNull(magazine.getTitle());
		assertNotNull(magazine.getIsbn());
		assertNotNull(magazine.getPublishDate());

	}

}
