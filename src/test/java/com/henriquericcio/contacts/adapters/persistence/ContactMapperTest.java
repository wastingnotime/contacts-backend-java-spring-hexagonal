package com.henriquericcio.contacts.adapters.persistence;

import com.henriquericcio.contacts.entities.Contact;
import lombok.val;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ContactMapperTest {

    private ContactMapper contactMapper = new ContactMapperImpl();

    @Test
    public void given_contact_should_convert_to_entity(){
        val contact = new Contact("firstName", "lastName","0000-0000");

        val expected = new ContactEntity();
        expected.setId(contact.getId().getValue());
        expected.setFirstName(contact.getFirstName());
        expected.setLastName(contact.getLastName());
        expected.setPhoneNumber(contact.getPhoneNumber());

        val actual = contactMapper.toJpaEntity(contact);

        assertThat(actual).isEqualToComparingFieldByField(expected);
    }
}
