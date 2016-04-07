package com.iman.bookmanagement.service;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.iman.bookmanagement.model.persons.Author;
import com.iman.bookmanagement.repository.ServiceRepository;
import com.iman.bookmanagement.service.author.AuthorService;
import com.iman.bookmanagement.service.author.AuthorServiceImpl;

public class AuthorServiceTests {

	@Before
	public void intialize() {
		ServiceRepository serviceRepository = new ServiceRepository();
	}
	@Test
	public void addAndGetAutorTest(){
		AuthorService autorService = ServiceRepository.getAuthorService();
		Author author = new Author("iman@java.de","Iman","Db");
		autorService.addAuthor(author);
		assertNotNull(autorService.getAuthor(author.getEmailAddress()));
	}
	@Test
	public void addAllAndGetAllAutorsTest(){
		AuthorService autorService = ServiceRepository.getAuthorService();
		Author author1 = new Author("iman@java.de","Iman","Db");
		Author author2 = new Author("db@java.de","max","musterman");
		List<Author> authors = new ArrayList<Author>();
		authors.add(author1);
		authors.add(author2);
		autorService.addAllAuthors(authors);
		assertNotNull(autorService.getAllAuthors());

		for(Author author:authors) {
			assertNotNull(autorService.getAuthor(author.getEmailAddress()));
		}
	}

	
}
