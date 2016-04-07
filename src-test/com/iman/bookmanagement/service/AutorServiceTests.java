package com.iman.bookmanagement.service;

import static org.junit.Assert.*;

import org.junit.Test;

import com.iman.bookmanagement.model.persons.Author;
import com.iman.bookmanagement.service.author.AuthorService;
import com.iman.bookmanagement.service.author.AuthorServiceImpl;

public class AutorServiceTests {

	@Test
	public void addAutorTest(){
		AuthorService autorService = new AuthorServiceImpl();
		Author author = new Author("iman@java.de","Iman","Db");
		autorService.addAuthor(author);
		assertNotNull(autorService.getAuthor(author.getEMail()));
	}
	
}
