package com.iman.bookmanagement.model.publishable;

import java.util.Date;
import java.util.List;

import com.iman.bookmanagement.model.persons.Author;
/**
 * Magazine Pojo
 * @author iman
 *
 */
public class Magazine extends Publishment {

	
	private Date publishDate;

	public Magazine(String title, List<Author> autors, String isbn, Date publishDate) {
		super(title, autors, isbn);
		this.setPublishDate(publishDate);
	}

	public Date getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}

}
