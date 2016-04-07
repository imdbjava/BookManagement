package com.iman.bookmanagement.model.publishable;

import java.util.List;

import com.iman.bookmanagement.model.persons.Author;

/**
 * super class Publishment. At the moment we have two subclasses book and magazine.
 * 
 * @author iman
 *
 */
public class Publishment {

	public Publishment(String title, List<Author> autors, String isbn) {
		this.title = title;
		this.autors = autors;
		this.isbn = isbn;
	}


	private String title;
	private List<Author> autors;
	private String isbn;
	
	
	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public List<Author> getAutors() {
		return autors;
	}


	public void setAutors(List<Author> autors) {
		this.autors = autors;
	}


	public String getIsbn() {
		return isbn;
	}


	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}


	
	
}

