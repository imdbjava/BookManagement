package csvReader;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.supercsv.io.CsvBeanReader;
import org.supercsv.io.ICsvBeanReader;
import org.supercsv.prefs.CsvPreference;

import persons.Autor;
import persons.Person;
/**
 * Unit Tests for SuperCSV.
 * @author iman
 *
 */
public class SuperCSVReaderTests {

	/**
	 * Let's test if SuperCSV is included in the project and is able to read a csv file.
	 */
	@Test
	public void loadAFileTest() {
        
		String csvFile = "/home/iman/Dropbox/Learn/BookManagement/data/autoren.csv";
	    ICsvBeanReader csvReader;
		try {
			csvReader = new CsvBeanReader(new FileReader(csvFile),
			        CsvPreference.STANDARD_PREFERENCE);
			
			String[] header = csvReader.getHeader(true);
			
			assertNotNull(header);
			assertTrue(header.length>0);
			assertEquals(header[0].split(";")[0],"Emailadresse");
			
		} catch (FileNotFoundException e) {
			fail("FileNotFound exception"+ e);
		}

		catch (IOException e) {
			fail("I/O exception"+ e);
		}
	}
	
	/** we want to write a test for converting csv to pojos.*/
	@Test
	public void convertCSVToPojoTest() {
		// we need a list autors to be filled
		List<Person> autors = new ArrayList<Person>(); 
		Autor autor = new Autor("iman@java.de","Iman","db");
		autors.add(autor);
		assertNotNull(autor);
		assertNotNull(autor.getEMail());
		
	}
}
