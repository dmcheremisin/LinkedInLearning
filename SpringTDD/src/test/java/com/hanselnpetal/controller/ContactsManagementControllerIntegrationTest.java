package com.hanselnpetal.controller;

import com.hanselnpetal.domain.CustomerContact;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static com.hanselnpetal.utils.Statuses.FAILURE;
import static com.hanselnpetal.utils.Statuses.SUCCESS;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public
class ContactsManagementControllerIntegrationTest {

    @Autowired
    ContactsManagementController contactsManagementController;

    @Test
    public void testAddContactHappyPath() {

        // Create a contact
        CustomerContact aContact = new CustomerContact();
        aContact.setFirstName("Jenny");
        aContact.setLastName("Johnson");

        // POST our CustomerContact form bean to the controller; check the outcome
        String outcome = contactsManagementController.addContact(aContact);

        // assert the expected outcome
        assertThat(outcome, is(equalTo(SUCCESS)));
    }

    @Test
    public void testAddContactFirstNameMissing() {

        // Create a contact
        CustomerContact aContact = new CustomerContact();

        // POST our CustomerContact form bean to the controller; check the outcome
        String outcome = contactsManagementController.addContact(aContact);

        // assert the expected outcome
        assertThat(outcome, is(equalTo(FAILURE)));
    }


}