package org.wastingnotime.contacts.adapters.persistence;

import org.wastingnotime.contacts.entities.Contact;
import lombok.val;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ContactPersistenceAdapterTest {

    @InjectMocks
    private ContactPersistenceAdapter contactPersistenceAdapter;

    @Mock
    private ContactRepository contactRepository;

    @Mock
    private ContactMapper contactMapper;

    @Test
    public void given_contact_should_convert_and_delegate_to_the_repository(){
        val contact = new Contact("firstName", "lastName","0000-0000");

        val expected = new ContactEntity();
        expected.setId(contact.getId().getValue());
        expected.setFirstName(contact.getFirstName());
        expected.setLastName(contact.getLastName());
        expected.setPhoneNumber(contact.getPhoneNumber());

        when(contactMapper.toJpaEntity(contact)).thenReturn(expected);

        contactPersistenceAdapter.save(contact);

        verify(contactMapper, times(1)).toJpaEntity(contact);
        verify(contactRepository, times(1)).save(expected);
    }
}

