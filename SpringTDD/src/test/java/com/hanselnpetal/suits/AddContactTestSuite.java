package com.hanselnpetal.suits;

import com.hanselnpetal.controller.ContactsManagementControllerIntegrationTest;
import com.hanselnpetal.repositories.CustomerContactRepositoryIntegrationTest;
import com.hanselnpetal.service.ContactsManagementServiceIntegrationTest;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.runner.RunWith;

@SuppressWarnings("JUnit5Platform")
@RunWith(JUnitPlatform.class)
@SelectClasses({ContactsManagementControllerIntegrationTest.class,
        CustomerContactRepositoryIntegrationTest.class,
        ContactsManagementServiceIntegrationTest.class})
public class AddContactTestSuite {
}
