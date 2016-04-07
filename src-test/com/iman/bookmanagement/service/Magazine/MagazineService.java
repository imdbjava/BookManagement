package com.iman.bookmanagement.service.Magazine;

import java.util.List;
import java.util.Map;

import com.iman.bookmanagement.model.publishable.Book;
import com.iman.bookmanagement.model.publishable.Magazine;
import com.iman.bookmanagement.service.Service;

public interface MagazineService extends Service {

	void addMagazine(Magazine magazine);

	Map<String,Magazine> getAllMagazines();
	
	void addAllMagazines(List<Magazine> magazines);

	Magazine getMagazine(String isbn);

}
