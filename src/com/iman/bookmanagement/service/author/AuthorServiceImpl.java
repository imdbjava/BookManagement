package com.iman.bookmanagement.service.author;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.iman.bookmanagement.model.persons.Author;

public class AuthorServiceImpl  implements AuthorService {

	private static Logger logger = Logger.getLogger(AuthorServiceImpl.class);
	  
	/** null by initialization. */
	private Map<String,Author> authors;
		
	/** initialize service. read all the files from the csv files.*/
	public AuthorServiceImpl() {
		authors = new HashMap<String,Author>();
	}
	public void addAuthor(Author author) {
		if(author != null && authors.containsKey(author.getEmailAddress())) {
		    logger.error("Author is already added");
		} else {
			authors.put(author.getEmailAddress(), author);
		}
	}
	public void addAllAuthors(List<Author> authors) {
		if(authors != null) {
		  for(Author author:authors) {
			addAuthor(author);
		  }
		}
	}

	public Author getAuthor(String Email) {	
		if(Email != null && Email.trim()!= ""){
			if(authors.containsKey(Email)) {
				return authors.get(Email);
				} else {
				    logger.error("Author not found.");
				    return null;
				}
		}
	    logger.error("Author not found, Email Argument was null.");
		return null;
		
	}
	
	public Map<String,Author> getAllAuthors() {
	  return authors;	
	}
	

}
