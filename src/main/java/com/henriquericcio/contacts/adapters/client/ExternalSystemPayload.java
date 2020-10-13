package com.henriquericcio.contacts.adapters.client;

import com.henriquericcio.contacts.entities.Contact;
import lombok.Data;

@Data
public class ExternalSystemPayload {
    private final String firstName;
    private final String phoneNumber;
    private final String lastName;

    //TODO: SRP vs convenience
    public static ExternalSystemPayload of(Contact contact) {
        return new ExternalSystemPayload(
                contact.getFirstName(),
                contact.getPhoneNumber(),
                contact.getLastName()
        );
    }
}
