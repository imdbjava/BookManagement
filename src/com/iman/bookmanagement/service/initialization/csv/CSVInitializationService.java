package com.iman.bookmanagement.service.initialization.csv;

import com.iman.bookmanagement.service.initialization.InitializationService;

public interface CSVInitializationService extends InitializationService {

	void initialize();
	void loadBookCSV(String fileName);
	void loadAutorCSV(String fileName);
	void loadMagazineCSV(String fileName);
}
