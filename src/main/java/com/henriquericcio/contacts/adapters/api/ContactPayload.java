package com.henriquericcio.contacts.adapters.api;

import lombok.Data;

@Data
public class ContactPayload {
    private final String firstName;
    private final String phoneNumber;
    private final String lastName;
}

