package com.henriquericcio.contacts.application;

import com.henriquericcio.contacts.entities.Contact;
import com.henriquericcio.contacts.inbound.CreateContactUseCase;
import com.henriquericcio.contacts.outbound.AdviceExternalSystem;
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
    private final AdviceExternalSystem adviceExternalSystem;

    @Override
    public Contact.ContactId create(CreateContactCommand command) {
        val contact = new Contact(command.getFirstName(), command.getLastName(), command.getPhoneNumber());

        saveContact.save(contact);
        adviceExternalSystem.tell(contact);

        return contact.getId();
    }
}
