package com.iman.bookmanagement.model.persons;

/** abstract class person. At the moment we only have one
 * type of person, namely Autor. This class can be useful for 
 * further developments.*/
public abstract class Person {
 
	private String Email;
	public Person(String email, String sureName, String familyName) {
		this.Email = email;
		this.sureName = sureName;
		this.FamilyName = familyName;
	}
	public String getEMail() {
		return Email;
	}
	public void setEMail(String eMail) {
		Email = eMail;
	}
	public String getSureName() {
		return sureName;
	}
	public void setSureName(String sureName) {
		this.sureName = sureName;
	}
	public String getFamilyName() {
		return FamilyName;
	}
	public void setFamilyName(String familyName) {
		FamilyName = familyName;
	}
	private String sureName;
	private String FamilyName;
}
