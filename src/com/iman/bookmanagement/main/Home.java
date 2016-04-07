package com.iman.bookmanagement.main;

import com.iman.bookmanagement.repository.ServiceRepository;
import com.iman.bookmanagement.service.initialization.csv.CSVInitializationService;
import com.iman.bookmanagement.service.initialization.csv.CSVInitializationServiceImpl;

public class Home {

	public static void main(String[] args) {
		String csvFile = "/home/iman/Dropbox/Learn/BookManagement/data/autoren.csv";
		ServiceRepository serviceRepository = new ServiceRepository();
		CSVInitializationService csvService = new CSVInitializationServiceImpl();
		csvService.loadAutorCSV(csvFile);
	}
}
