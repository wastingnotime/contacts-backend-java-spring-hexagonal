package com.henriquericcio.contacts.adapters.persistence;

import lombok.val;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class ContactRepositoryTest {

    @Autowired
    private ContactRepository contactRepository;

    @Test
    public void given_contact_should_persist(){

        val actual = new ContactEntity();
        actual.setId("one");
        actual.setFirstName("two");
        actual.setPhoneNumber("three");
        actual.setLastName("four");

        contactRepository.save(actual);

        val expected = contactRepository.findById(actual.getId()).orElse(null);

        assertThat(expected).isNotNull();
        assertThat(actual).isEqualToComparingFieldByField(expected);
    }
}
