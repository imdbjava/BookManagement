package com.iman.bookmanagement.service.publishment;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import com.iman.bookmanagement.model.publishable.Publishment;
import com.iman.bookmanagement.service.Service;

public interface PublishmentService extends Service{

	void addPublishment(Publishment publishment);

	Map<String,Publishment> getAllPublishments();
	
	void addAllPublishments(ArrayList<Publishment> publishments);

	Publishment getPublishment(String isbn);
	
	/** search the publications by email. **/
	List<Publishment> findPublishmentsByAuthor(String email);
	
	/** get all publishments sorted by title. **/
	Stream<Publishment> getAllPublishmentsSortedByTitle();
	

}
