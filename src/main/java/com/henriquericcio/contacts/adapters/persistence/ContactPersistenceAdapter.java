package com.henriquericcio.contacts.adapters.persistence;

import com.henriquericcio.contacts.entities.Contact;
import com.henriquericcio.contacts.outbound.SaveContact;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class ContactPersistenceAdapter implements SaveContact {
    private final ContactRepository contactRepository;

    @Override
    public void save(Contact contact) {
        log.info("Trying to save {}",contact.getId().getValue());

        contactRepository.save(ContactEntity.of(contact));
    }
}
