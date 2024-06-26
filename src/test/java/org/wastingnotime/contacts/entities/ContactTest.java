package org.wastingnotime.contacts.entities;

import lombok.val;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ContactTest {
    @Test
    public void given_any_parameters_should_instantiate_new_entity(){
        val contact = new Contact(null,null,null);

        assertThat(contact).isNotNull();
        assertThat(contact.getId()).isNotNull();
    }
}
