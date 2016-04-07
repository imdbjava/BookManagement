package initialization;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.print.DocFlavor.URL;

import org.junit.Test;
import org.supercsv.io.CsvBeanReader;
import org.supercsv.io.ICsvBeanReader;
import org.supercsv.prefs.CsvPreference;

public class IntialTest {

	/**
	 * Let's test if SuperCSV is included in the project.
	 */
	@Test
	public void testSuperCsv() {
        
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
}
