package com.hanselnpetal.repositories;

import org.springframework.data.repository.CrudRepository;

import com.hanselnpetal.domain.CustomerContact;

public interface CustomerContactRepository extends CrudRepository<CustomerContact, Long> {

    CustomerContact findByEmail(String email);
}
