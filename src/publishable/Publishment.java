package publishable;

import java.util.List;

import persons.Autor;

/**
 * super class Publishment. At the moment we have two subclasses book and magazine.
 * 
 * @author iman
 *
 */
public class Publishment {

	public Publishment(String title, List<Autor> autors, String isbn) {
		this.title = title;
		this.autors = autors;
		this.isbn = isbn;
	}


	private String title;
	private List<Autor> autors;
	private String isbn;
	
	
	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public List<Autor> getAutors() {
		return autors;
	}


	public void setAutors(List<Autor> autors) {
		this.autors = autors;
	}


	public String getIsbn() {
		return isbn;
	}


	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}


	
	
}

