
package com.iman.bookmanagement.service;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import com.iman.bookmanagement.model.persons.Author;
import com.iman.bookmanagement.model.publishable.Book;
import com.iman.bookmanagement.model.publishable.Publishment;
import com.iman.bookmanagement.repository.ServiceRepository;
import com.iman.bookmanagement.service.author.AuthorService;
import com.iman.bookmanagement.service.author.AuthorServiceImpl;
import com.iman.bookmanagement.service.publishment.PublishmentService;

public class PublishmentServiceTests {

	@Before
	public void intialize() {
		ServiceRepository serviceRepository = new ServiceRepository();
	}

	@Test
	public void addAndGetBookTest(){
		PublishmentService PublishmentService = ServiceRepository.getPushlishmentService();
		String isbn = "1-56619-909-3";
		// TODO check ISBN validation.
		Book book= new Book("book title","test@email.de",isbn,"short desc");
		PublishmentService.addPublishment(book);
		assertNotNull(PublishmentService.getPublishment(isbn));
	}
	@Test
	public void addAllAndGetAllBooksTest(){

		PublishmentService publishmentService = ServiceRepository.getPushlishmentService();
		String isbn1 = "1-56619-909-3";
		String isbn2 = "2-56619-909-4";
		
		// TODO check ISBN validation.
		Book book1= new Book("book title1","test1@email.de",isbn1,"short desc 1");
		Book book2= new Book("book title2","test2@email.de",isbn2,"short desc 2");
		ArrayList<Publishment> books= new ArrayList<Publishment>();
		books.add(book1);
		books.add(book2);
		
		publishmentService.addAllPublishments(books);
		assertNotNull(publishmentService.getAllPublishments());
		
		for(Publishment pub:books) {
			assertNotNull(publishmentService.getPublishment(pub.getIsbn()));
		}
	}
}