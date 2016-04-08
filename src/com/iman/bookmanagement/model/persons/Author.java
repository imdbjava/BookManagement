package com.iman.bookmanagement.model.persons;

/**  Pojo for Author class*/
public class Author {
	private String emailAddress;
	private String sureName;
	private String familyName;

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getSureName() {
		return sureName;
	}

	public void setSureName(String sureName) {
		this.sureName = sureName;
	}

	public String getFamilyName() {
		return familyName;
	}

	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}

	
	// empty constructor for SuperCSV
	public Author() {
		
	}
	
	public Author(String email, String sureName, String familyName) {
		this.emailAddress = email;
		this.sureName = sureName;
		this.familyName = familyName;
	}

	@Override
	public String toString() {
		return sureName + " " + familyName;
	}
	
	public String authorDetails() {
		return "Author ["+sureName + " " + familyName + ", Email = ]"+ emailAddress;
	}

	

}
