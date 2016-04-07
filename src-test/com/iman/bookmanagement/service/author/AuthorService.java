package com.iman.bookmanagement.service.author;

import java.util.List;

import com.iman.bookmanagement.model.persons.Author;
import com.iman.bookmanagement.service.Service;

public interface AuthorService extends Service {

	void addAuthor(Author author);
    void addAllAuthors(List<Author> authors) ;
	Author getAuthor(String Email);
	List<Author> getAllAuthors() ;
		


}
