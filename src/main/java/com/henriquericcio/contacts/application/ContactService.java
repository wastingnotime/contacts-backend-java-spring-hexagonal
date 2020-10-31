package com.henriquericcio.contacts.application;

import com.henriquericcio.contacts.adapters.persistence.ContactRepository;
import com.henriquericcio.contacts.entities.Contact;
import com.henriquericcio.contacts.inbound.CreateContactUseCase;
import com.henriquericcio.contacts.inbound.DeleteContactUseCase;
import com.henriquericcio.contacts.inbound.UpdateContactUseCase;
import com.henriquericcio.contacts.inbound.common.NotFoundException;
import com.henriquericcio.contacts.outbound.DeleteContact;
import com.henriquericcio.contacts.outbound.SaveContact;
import com.henriquericcio.contacts.outbound.UpdateContact;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
@RequiredArgsConstructor
public class ContactService implements CreateContactUseCase, DeleteContactUseCase, UpdateContactUseCase {
    private final SaveContact saveContact;
    private final DeleteContact deleteContact;
    private final UpdateContact updateContact;
    private final ContactRepository contactRepository;

    @Override
    public Contact.ContactId create(CreateContactCommand command) {
        val contact = new Contact(command.getFirstName(), command.getLastName(), command.getPhoneNumber());
        saveContact.save(contact);

        return contact.getId();
    }

    @Override
    public void delete(DeleteContactCommand command) throws NotFoundException {
        if (!contactRepository.existsById(command.getId()))
            throw new NotFoundException(command.getId());

        deleteContact.delete(new Contact.ContactId(command.getId()));
    }

    @Override
    public void update(UpdateContactCommand command) throws NotFoundException {
        if (!contactRepository.existsById(command.getId()))
            throw new NotFoundException(command.getId());

        val contact = new Contact(command.getFirstName(), command.getLastName(), command.getPhoneNumber());

        updateContact.update(contact);
    }
}
