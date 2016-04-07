package com.iman.bookmanagement.csvReader;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.junit.Test;
import org.supercsv.io.CsvBeanReader;
import org.supercsv.io.ICsvBeanReader;
import org.supercsv.prefs.CsvPreference;

import com.iman.bookmanagement.model.persons.Author;
import com.iman.bookmanagement.model.persons.Author;
import com.iman.bookmanagement.model.publishable.Book;
import com.iman.bookmanagement.model.publishable.Magazine;
import com.iman.bookmanagement.model.publishable.Publishment;
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
	
}
