package com.iman.bookmanagement.service.publishment;

import java.util.List;
import java.util.Map;

import com.iman.bookmanagement.model.publishable.Publishment;
import com.iman.bookmanagement.service.Service;

public interface PublishmentService extends Service{

	void addPublishment(Publishment publishment);

	Map<String,Publishment> getAllPublishments();
	
	void addAllPublishments(List<Publishment> publishments);

	Publishment getPublishment(String isbn);
	
	/** search the publications by email. **/
	List<Publishment> findPublishmentsByAuthor(String email);

}
