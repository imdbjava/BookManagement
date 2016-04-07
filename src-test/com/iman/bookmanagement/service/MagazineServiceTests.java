package com.iman.bookmanagement.service;

import static org.junit.Assert.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.junit.Test;

import com.iman.bookmanagement.model.persons.Author;
import com.iman.bookmanagement.model.publishable.Magazine;
import com.iman.bookmanagement.service.Magazine.MagazineService;
import com.iman.bookmanagement.service.Magazine.MagazineServiceImpl;
import com.iman.bookmanagement.service.author.AuthorService;
import com.iman.bookmanagement.service.author.AuthorServiceImpl;

public class MagazineServiceTests {

	@Test
	public void addAndGetMagazineTest(){
		AuthorService autorService = new AuthorServiceImpl();
		Author author = new Author("iman@java.de","Iman","Db");
		autorService.addAuthor(author);
		assertNotNull(autorService.getAuthor(author.getEmailadresse()));
		List<Author> authors = new ArrayList<Author>();
		authors.add(author);

		MagazineService magazineService = new MagazineServiceImpl();
		String isbn = "1-56619-902-4";
		// TODO check ISBN validation.
		String dateString = "10.10.2016";
		DateFormat format = new SimpleDateFormat("dd.MM.yyyy", Locale.GERMANY);
		Date date = null;
		try {
			date = format.parse(dateString);
		} catch (ParseException e) {
			fail("Date format Parse Exceptoin"+ e);
		}
	    assertNotNull(date); 
		Magazine magazine= new Magazine("magazine title",authors,isbn,date);
		magazineService.addMagazine(magazine);
		assertNotNull(magazineService.getMagazine(isbn));
	}
	@Test
	public void addAllAndGetAllMagazinesTest(){
		AuthorService autorService = new AuthorServiceImpl();
		Author author = new Author("iman@java.de","Iman","Db");
		autorService.addAuthor(author);
		assertNotNull(autorService.getAuthor(author.getEmailadresse()));
		List<Author> authors = new ArrayList<Author>();
		authors.add(author);

		MagazineService magazineService = new MagazineServiceImpl();
		
		// TODO check ISBN validation.
		List<Magazine> magazines= new ArrayList<Magazine>();
		
		String isbn1 = "1-56619-902-4";
		String isbn2 = "1-56619-902-56";
		// TODO check ISBN validation.
		String dateString = "10.10.2016";
		DateFormat format = new SimpleDateFormat("dd.MM.yyyy", Locale.GERMANY);
		Date date = null;
		try {
			date = format.parse(dateString);
		} catch (ParseException e) {
			fail("Date format Parse Exceptoin"+ e);
		}
	    assertNotNull(date); 
		Magazine magazine1= new Magazine("magazine title1",authors,isbn1,date);
		Magazine magazine2= new Magazine("magazine title2",authors,isbn2,date);

	
		magazines.add(magazine1);
		magazines.add(magazine2);
		
		magazineService.addAllMagazines(magazines);
		assertNotNull(magazineService.getAllMagazines());
		
		for(Magazine magazine:magazines) {
			assertNotNull(magazineService.getMagazine(magazine.getIsbn()));
		}
	}

}
