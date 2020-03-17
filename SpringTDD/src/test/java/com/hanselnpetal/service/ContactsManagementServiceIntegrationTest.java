package com.hanselnpetal.service;

import com.hanselnpetal.domain.CustomerContact;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(webEnvironment = WebEnvironment.NONE)
public class ContactsManagementServiceIntegrationTest {
	
	@Autowired
	private ContactsManagementService contactsManagementService;
	
	@Test
	public void testAddContactHappyPath() {
		
		// Create a contact
		CustomerContact aContact = new CustomerContact();
		aContact.setFirstName("Jenny");
		aContact.setLastName("Johnson");

		// Test adding the contact
		CustomerContact newContact = contactsManagementService.add(aContact);

		// Verify the addition
		assertNotNull(newContact);
		assertEquals("Jenny", newContact.getFirstName());
	}
}
