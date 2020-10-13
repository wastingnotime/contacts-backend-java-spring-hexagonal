package com.henriquericcio.contacts.outbound;

import com.henriquericcio.contacts.entities.Contact;

public interface AdviceExternalSystem {
    void tell(Contact contact);
}
