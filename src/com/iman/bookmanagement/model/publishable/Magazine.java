package com.iman.bookmanagement.model.publishable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import com.iman.bookmanagement.model.persons.Author;
import com.iman.bookmanagement.service.author.AuthorServiceImpl;

/**
 * Magazine Pojo
 * @author iman
 *
 */
public class Magazine extends Publishment {

	private static Logger logger = Logger.getLogger(AuthorServiceImpl.class);

	// for SuperCSV
	public Magazine() {
		
	}
	private Date publishDate;
	private String authorsEmail;

	public Magazine(String title, List<Author> autors, String isbn, Date publishDate) {
		super(title, autors, isbn);
		this.setPublishDate(publishDate);
	}

	@Override
	public String toString() {
		return "Magazine [Title=" + getTitle() + ",PublishDate =" + getPublishDate() + ", ISBN="
				+ getIsbn() + ", Autors=" + getAutors() + "]";
	}

	public Date getPublishDate() {
		return publishDate;
	}

	/**
	 *@param publishDate is String for SuperCSV. */
	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
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

	public List<String> getAuthorsEmail() {
		
		return Arrays.asList(authorsEmail.split(","));
	}
	public void setAuthorsEmail(String authorsEmail) {
		this.authorsEmail = authorsEmail;
	}


}
