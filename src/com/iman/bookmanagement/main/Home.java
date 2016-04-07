package com.iman.bookmanagement.main;

import com.iman.bookmanagement.repository.ServiceRepository;
import com.iman.bookmanagement.service.initialization.csv.CSVInitializationService;
import com.iman.bookmanagement.service.initialization.csv.CSVInitializationServiceImpl;

public class Home {

	public static void main(String[] args) {
		// First we initialize the service repository
		ServiceRepository serviceRepository = new ServiceRepository();

		// load all the authors.
		String csvFile = "/home/iman/Dropbox/Learn/BookManagement/data/autoren.csv";
		CSVInitializationService csvService = new CSVInitializationServiceImpl();
		csvService.loadAutorCSV(csvFile);
		
		// load all the books
		
	}
}
