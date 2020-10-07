package com.henriquericcio.contacts.application;

import com.henriquericcio.contacts.entities.Contact;
import com.henriquericcio.contacts.inbound.CreateContactUseCase;
import com.henriquericcio.contacts.outbound.SaveContact;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
@RequiredArgsConstructor
public class CreateContactService implements CreateContactUseCase {
    private final SaveContact saveContact;

    @Override
    public Contact.ContactId create(CreateContactCommand command) {
        val contact = new Contact(command.getFirstName(), command.getLastName(), command.getPhoneNumber());

        saveContact.save(contact);

        return contact.getId();
    }
}
