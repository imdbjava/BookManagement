package com.iman.bookmanagement.model.publishable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.iman.bookmanagement.model.persons.Author;

/**
 * Book Pojo
 * @author iman
 *
 */
public class Book extends Publishment {
	
	
	private String shortDescription;
	
	/* this field is only for csv mapping. */
	private String authorsEmail;

	public Book(String title, List<Author> autors, String isbn, String shortDesc) {
		super(title, autors, isbn);
		this.setShortDescription(shortDesc);
	}
	public Book() {
		
	}


	public String getShortDescription() {
		return shortDescription;
	}
	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}
	
	public void  setTitle(String title) {
		super.setTitle(title);
	}
	
	public String getTitle() {
		return super.getTitle();
	}

	public void setIsbn(String isbn) {
		super.setIsbn(isbn);
	}
	public String getIsbn() {
		return super.getIsbn();
	}
	public void setAutors(List<Author> authors) {
		super.setAutors(authors);
	}
	public List<Author> getAutors() {
		return super.getAutors();
	}
	
	@Override
	public String toString() {
		return "Book [Title=" + getTitle() +",ShortDescription=" + getShortDescription() +  ", ISBN="
				+ getIsbn() + ", Autors=" + getAutors() + "]";
	}
	public List<String> getAuthorsEmail() {
		
		return  Arrays.asList(authorsEmail.split(","));
	}
	public void setAuthorsEmail(String authorsEmail) {
		this.authorsEmail = authorsEmail;
	}
	
	

	
}
