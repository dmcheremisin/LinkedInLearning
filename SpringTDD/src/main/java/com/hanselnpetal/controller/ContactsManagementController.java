package com.hanselnpetal.controller;

import com.hanselnpetal.domain.CustomerContact;
import com.hanselnpetal.service.ContactsManagementService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static com.hanselnpetal.utils.Statuses.FAILURE;
import static com.hanselnpetal.utils.Statuses.SUCCESS;

@RestController
@RequiredArgsConstructor
public class ContactsManagementController {

    private final ContactsManagementService contactsManagementService;

    @PostMapping("/addContact")
    public String addContact(@RequestBody CustomerContact customerContact) {
        CustomerContact savedContact = null;

        if (customerContact.getFirstName() != null)
            savedContact = contactsManagementService.add(customerContact);

        return savedContact != null ? SUCCESS : FAILURE;
    }
}
