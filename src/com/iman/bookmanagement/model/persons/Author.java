package com.iman.bookmanagement.model.persons;

/**  Pojo for Author class*/
public class Author {
	private String Emailadresse;
	private String Vorname;
	private String Nachname;
	
	// empty constructor for SuperCSV
	public Author() {
		
	}
	
	public Author(String emailadresse, String vorname, String nachname) {
		super();
		Emailadresse = emailadresse;
		Vorname = vorname;
		Nachname = nachname;
	}


	public String getEmailadresse() {
		return Emailadresse;
	}
	public void setEmailadresse(String emailadresse) {
		Emailadresse = emailadresse;
	}
	public String getVorname() {
		return Vorname;
	}
	public void setVorname(String vorname) {
		Vorname = vorname;
	}
	public String getNachname() {
		return Nachname;
	}
	public void setNachname(String nachname) {
		Nachname = nachname;
	}
}
