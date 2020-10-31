package com.henriquericcio.contacts.adapters.persistence;

import com.henriquericcio.contacts.entities.Contact;
import com.henriquericcio.contacts.outbound.DeleteContact;
import com.henriquericcio.contacts.outbound.SaveContact;
import com.henriquericcio.contacts.outbound.UpdateContact;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class ContactPersistenceAdapter implements SaveContact, UpdateContact, DeleteContact {
    private final ContactRepository contactRepository;

    @Override
    public void save(Contact contact) {
        log.info("Trying to save {}",contact.getId().getValue());

        contactRepository.save(ContactMapper.INSTANCE.toJpaEntity(contact));
    }

    @Override
    public void delete(Contact.ContactId contactId) {
        contactRepository.deleteById(contactId.getValue());
    }

    @Override
    public void update(Contact contact) {
        contactRepository.save(ContactMapper.INSTANCE.toJpaEntity(contact));
    }
}
