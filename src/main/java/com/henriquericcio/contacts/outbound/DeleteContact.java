package com.henriquericcio.contacts.outbound;

import com.henriquericcio.contacts.entities.Contact;

public interface DeleteContact {
    void delete(Contact.ContactId contactId);
}
