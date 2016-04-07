package pojos;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.junit.Test;

import persons.Autor;
import publishable.Book;
import publishable.Magazine;
import publishable.Publishment;

public class PojosTests {

	/** we want to write a test for converting csv to pojos.*/
	@Test
	public void createPojosTest() {
		// we need a list autors to be filled
		List<Autor> autors = new ArrayList<Autor>(); 
		Autor autor = new Autor("iman@java.de","Iman","Db");
		autors.add(autor);
		assertNotNull(autors);
		assertEquals(autors.get(0), autor);
		assertNotNull(autor);
		assertNotNull(autor.getEMail());
		assertEquals(autor.getEMail(), "iman@java.de");
		assertNotNull(autor.getSureName());
		assertNotNull(autor.getFamilyName());
		// we also need some books and magazines. namely publishables
		List<Publishment> publishments = new ArrayList<Publishment>();
		String isbn = "1-56619-909-3";
		// TODO check ISBN validation.
		Book book= new Book("book title",autors,isbn,"short desc");
		assertNotNull(book.getShortDescription());
		assertNotNull(book.getIsbn());
		assertNotNull(book.getTitle());
		assertNotNull(book.getAutors());
		
		String string = "2015-10-10";
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.GERMANY);
		Date date = null;
		try {
			date = format.parse(string);
		} catch (ParseException e) {
			fail("Date format Parse Exceptoin"+ e);
		}
	    assertNotNull(date); 
		
		Magazine magazine = new Magazine("magazine title",autors,isbn, date);
		assertNotNull(magazine.getAutors());
		assertNotNull(magazine.getTitle());
		assertNotNull(magazine.getIsbn());
		assertNotNull(magazine.getPublishDate());

	}

}
