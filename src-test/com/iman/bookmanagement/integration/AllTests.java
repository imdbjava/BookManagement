package com.iman.bookmanagement.integration;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.iman.bookmanagement.csvReader.SuperCSVReaderTests;
import com.iman.bookmanagement.model.ModelTests;
import com.iman.bookmanagement.service.AuthorServiceTests;
import com.iman.bookmanagement.service.CSVInitServiceTests;
import com.iman.bookmanagement.service.PublishmentServiceTests;

@RunWith(Suite.class)
@SuiteClasses({ FunctionalTests.class, 
	SuperCSVReaderTests.class
	, ModelTests.class, 
	AuthorServiceTests.class,
	CSVInitServiceTests.class,
	PublishmentServiceTests.class})
public class AllTests {

}
