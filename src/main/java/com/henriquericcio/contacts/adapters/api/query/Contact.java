package com.henriquericcio.contacts.adapters.api.query;

import lombok.Value;

@Value
public class Contact {
    String id;
    String firstName;
    String phoneNumber;
    String lastName;
}