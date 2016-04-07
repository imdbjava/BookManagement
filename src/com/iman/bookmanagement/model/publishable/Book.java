package com.iman.bookmanagement.model.publishable;

import java.util.List;

import com.iman.bookmanagement.model.persons.Author;

/**
 * Book Pojo
 * @author iman
 *
 */
public class Book extends Publishment {

	
	private String shortDescription;

	public Book(String title, List<Author> autors, String isbn, String shortDesc) {
		super(title, autors, isbn);
		this.setShortDescription(shortDesc);
	}

	public String getShortDescription() {
		return shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	
}
