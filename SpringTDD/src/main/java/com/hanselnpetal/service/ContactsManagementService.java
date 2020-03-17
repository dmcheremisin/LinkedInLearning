package com.hanselnpetal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hanselnpetal.repositories.CustomerContactRepository;
import com.hanselnpetal.domain.CustomerContact;

@Service
public class ContactsManagementService {

	@Autowired
	private CustomerContactRepository customerContactRepository;
	
	public CustomerContact add(CustomerContact aContact) {
		return customerContactRepository.save(aContact);
	}
	
	/*
	public CustomerContact addContactOccasion(CustomerContact aContact, ContactImportantOccasion anOccasion) {
		CustomerContact newContact = null;
		
		return newContact;	
	}
	*/
}
