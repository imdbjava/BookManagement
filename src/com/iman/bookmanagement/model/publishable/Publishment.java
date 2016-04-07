package com.iman.bookmanagement.model.publishable;



/**
 * super class Publishment. At the moment we have two subclasses book and magazine.
 * 
 * @author iman
 *
 */
public class Publishment {

	public Publishment() {
		
	}
	public Publishment(String title, String autors, String isbn) {
		this.title = title;
		this.authors = autors;
		this.isbn = isbn;
	}


	private String title;
	private String authors;
	private String isbn;
	
	
	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getAutors() {
		return authors;
	}


	public void setAutors(String autors) {
		this.authors = autors;
	}


	public String getIsbn() {
		return isbn;
	}


	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}


	
	
}

