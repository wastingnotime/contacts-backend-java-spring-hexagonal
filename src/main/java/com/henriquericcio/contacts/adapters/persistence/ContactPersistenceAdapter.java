package com.henriquericcio.contacts.adapters.persistence;

import com.henriquericcio.contacts.entities.Contact;
import com.henriquericcio.contacts.outbound.SaveContact;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ContactPersistenceAdapter implements SaveContact {
    private final ContactRepository contactRepository;

    @Override
    public void save(Contact contact) {
        contactRepository.save(ContactEntity.of(contact));
    }
}
