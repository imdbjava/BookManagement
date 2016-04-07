package com.iman.bookmanagement.service.Magazine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import com.iman.bookmanagement.model.publishable.Magazine;

public class MagazineServiceImpl implements MagazineService {

	private static Logger logger = Logger.getLogger(MagazineServiceImpl.class);

	Map<String, Magazine> magazines;
	
	public MagazineServiceImpl() {
		magazines = new HashMap<String, Magazine>();
		BasicConfigurator.configure();
	}
	public void addMagazine(Magazine magazine) {
		if(magazine != null && ! magazines.containsKey(magazine.getIsbn())) {
			magazines.put(magazine.getIsbn(), magazine);
		} else {
			// of course we can seperate these two error checkings
			logger.error("magazine already exists or the parameter was null");
		}

	}

	public Map<String, Magazine> getAllMagazines() {
		return magazines;
	}

	public void addAllMagazines(List<Magazine> magazines) {
		if(magazines != null) {
			for(Magazine magazine:magazines) {
				addMagazine(magazine);
			}
		} else {
			logger.error("magazines parameter was null");
		}

	}

	public Magazine getMagazine(String isbn) {
		if(isbn != null && isbn.trim() != "") {
			if(magazines.containsKey(isbn)) {
				return magazines.get(isbn);
			} else {
				logger.error("Magazine not found");
			}
		} else {
			logger.error("isbn parameter was null or empty");
		}
		return null;
	}

}
