package com.iman.bookmanagement.model.publishable;

import java.util.Date;

/**
 * Magazine Pojo
 * @author iman
 *
 */
public class Magazine extends Publishment {

	public Magazine() {
		
	}
	private String publishDate;

	public Magazine(String title, String autors, String isbn, String publishDate) {
		super(title, autors, isbn);
		this.setPublishDate(publishDate);
	}

	public String getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(String publishDate) {
		this.publishDate = publishDate;
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
