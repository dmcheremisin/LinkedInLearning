package com.hanselnpetal.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hanselnpetal.domain.CustomerContact;
import com.hanselnpetal.service.ContactsManagementService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static com.hanselnpetal.utils.Statuses.FAILURE;
import static com.hanselnpetal.utils.Statuses.SUCCESS;
import static org.hamcrest.Matchers.containsString;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ContactsManagementController.class)
class ContactsManagementControllerUnitTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    private ContactsManagementService contactsManagementService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testAddContactHappyPath() throws Exception {
        // Create a contact
        CustomerContact aContact = new CustomerContact();
        aContact.setFirstName("Jenny");
        aContact.setLastName("Johnson");

        when(contactsManagementService.add(any(CustomerContact.class)))
                .thenReturn(aContact);

        mockMvc
                .perform(post("/addContact")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(aContact)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", containsString(SUCCESS)));
    }

    @Test
    public void testAddContactForgotFirstName() throws Exception {
        // Create a contact
        CustomerContact aContact = new CustomerContact();
        aContact.setLastName("Johnson");

        mockMvc
                .perform(post("/addContact")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(aContact)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", containsString(FAILURE)));
    }

}