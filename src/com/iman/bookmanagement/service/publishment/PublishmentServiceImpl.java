package com.iman.bookmanagement.service.publishment;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Stream;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import com.iman.bookmanagement.model.persons.Author;
import com.iman.bookmanagement.model.publishable.Publishment;

public class PublishmentServiceImpl implements PublishmentService {

	private static Logger logger = Logger.getLogger(PublishmentService.class);

    Map<String,Publishment> publishments;
	
	public PublishmentServiceImpl() {
		publishments = new HashMap<String, Publishment>();
		BasicConfigurator.configure();
	}
	
	public void addPublishment(Publishment publishment) {
		if(publishment!= null && ! publishments.containsKey(publishment.getIsbn())) {
			publishments.put(publishment.getIsbn(), publishment);
		} else {
			logger.error("publishment already exists or the parameter was null");

		}

	}

	public Map<String, Publishment> getAllPublishments() {
		return publishments;
	}

	public void addAllPublishments(ArrayList<Publishment> publishments) {
		if(publishments != null) {
			for(Publishment publishment:publishments) {
				addPublishment(publishment);
			}
			} else {
				logger.error("publishment argument was null");
			}
			
		
	}

	public Publishment getPublishment(String isbn) {
		if(isbn!= null && isbn.trim() != "") {
			if(publishments.containsKey(isbn)) {
			return publishments.get(isbn);
			} else {
				logger.error("publishment not found.");
			}
		}else  {
			logger.error("isbn parameter was null or empty");
		}
			return null;	
			
	}

		

	public List<Publishment> findPublishmentsByAuthor(Author author) {
		List<Publishment> foundedPublishments = new ArrayList<Publishment>();
		for(Entry<String,Publishment> entry :publishments.entrySet()) {
			if(entry.getValue().getAutors().contains(author))
				foundedPublishments.add(entry.getValue());
		}
		return foundedPublishments;

		
	}

	public Stream<Publishment> getAllPublishmentsSortedByTitle() {
		Collection<Publishment> allPublishments=
				publishments.values();
		return  allPublishments.stream()
		  .sorted((object1, object2) -> object1.getTitle().compareTo(object2.getTitle()));
		
	}


	


}
