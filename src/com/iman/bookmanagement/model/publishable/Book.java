package com.iman.bookmanagement.model.publishable;


/**
 * Book Pojo
 * @author iman
 *
 */
public class Book extends Publishment {
	
	
	private String shortDescription;

	public Book(String title, String autors, String isbn, String shortDesc) {
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

	public void setISBN(String isbn) {
		super.setIsbn(isbn);
	}
	public String getISBN() {
		return super.getIsbn();
	}
	public void setAutors(String authors) {
		super.setAutors(authors);
	}
	public String getAutors() {
		return super.getAutors();
	}
	
	

	
}
