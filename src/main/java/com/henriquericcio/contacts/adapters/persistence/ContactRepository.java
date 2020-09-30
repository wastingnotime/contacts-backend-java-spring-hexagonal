package com.henriquericcio.contacts.adapters.persistence;

import org.springframework.data.repository.CrudRepository;

public interface ContactRepository extends CrudRepository<ContactEntity, String> {
}