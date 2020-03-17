package com.hanselnpetal.repositories;

import com.hanselnpetal.domain.CustomerContact;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

@DataJpaTest
public
class CustomerContactRepositoryIntegrationTest {

    public static final String EMAIL = "jen@simson.com";

    @Autowired
    TestEntityManager entityManager;

    @Autowired
    CustomerContactRepository customerContactRepository;

    @Test
    public void testfindByEmail() {
        CustomerContact aContact = new CustomerContact();
        aContact.setFirstName("Jen");
        aContact.setLastName("Simson");
        aContact.setEmail(EMAIL);

        entityManager.persist(aContact);

        CustomerContact contact = customerContactRepository.findByEmail(EMAIL);

        assertThat(contact.getEmail(), is(equalTo(EMAIL)));
    }
}