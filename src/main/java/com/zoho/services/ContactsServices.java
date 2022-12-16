package com.zoho.services;

import java.util.List;

import com.zoho.entities.Contacts;

public interface ContactsServices {
	
	public void saveContactInfo(Contacts contacts);
	
	public List<Contacts> getAllContacts();
	
	public Contacts findContactById(long id);

}
