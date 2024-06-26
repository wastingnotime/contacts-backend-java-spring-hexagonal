package org.wastingnotime.contacts.application;

import org.wastingnotime.contacts.adapters.persistence.ContactRepository;
import org.wastingnotime.contacts.entities.Contact;
import org.wastingnotime.contacts.inbound.CreateContactUseCase;
import org.wastingnotime.contacts.inbound.DeleteContactUseCase;
import org.wastingnotime.contacts.inbound.UpdateContactUseCase;
import org.wastingnotime.contacts.inbound.common.NotFoundException;
import org.wastingnotime.contacts.outbound.DeleteContact;
import org.wastingnotime.contacts.outbound.SaveContact;
import org.wastingnotime.contacts.outbound.UpdateContact;
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
