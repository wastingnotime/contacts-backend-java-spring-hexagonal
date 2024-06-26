package org.wastingnotime.contacts.outbound;

import org.wastingnotime.contacts.entities.Contact;

public interface DeleteContact {
    void delete(Contact.ContactId contactId);
}
