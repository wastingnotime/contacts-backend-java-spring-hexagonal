package org.wastingnotime.contacts.adapters.persistence;

import org.wastingnotime.contacts.entities.Contact;
import org.wastingnotime.contacts.outbound.DeleteContact;
import org.wastingnotime.contacts.outbound.SaveContact;
import org.wastingnotime.contacts.outbound.UpdateContact;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class ContactPersistenceAdapter implements SaveContact, UpdateContact, DeleteContact {
    private final ContactRepository contactRepository;
    private final ContactMapper contactMapper;

    @Override
    public void save(Contact contact) {
        log.info("Trying to save {}",contact.getId().getValue());

        contactRepository.save(contactMapper.toJpaEntity(contact));
    }

    @Override
    public void delete(Contact.ContactId contactId) {
        contactRepository.deleteById(contactId.getValue());
    }

    @Override
    public void update(Contact contact) {
        contactRepository.save(contactMapper.toJpaEntity(contact));
    }
}
