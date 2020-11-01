package com.henriquericcio.contacts.adapters.api;

import lombok.Value;

@Value
public class ContactPayload {
    String firstName;
    String phoneNumber;
    String lastName;
}

