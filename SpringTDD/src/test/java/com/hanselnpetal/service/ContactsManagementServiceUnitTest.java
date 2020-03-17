package com.hanselnpetal.service;

import com.hanselnpetal.domain.CustomerContact;
import com.hanselnpetal.repositories.CustomerContactRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class ContactsManagementServiceUnitTest {

	@Mock
	private CustomerContactRepository customerContactRepository;

	@InjectMocks
	private ContactsManagementService contactsManagementService;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testAddContactHappyPath() {
		
		// Create a contact
		CustomerContact aContact = new CustomerContact();
		aContact.setFirstName("Jenny");
		aContact.setLastName("Johnson");

		// mock repository behavior
		when(customerContactRepository.save(any(CustomerContact.class))).thenReturn(aContact);

		// save contact
		CustomerContact contact = contactsManagementService.add(new CustomerContact());

		// verify save
		assertEquals("Jenny", contact.getFirstName());
		assertEquals("Johnson", contact.getLastName());
	}
}
