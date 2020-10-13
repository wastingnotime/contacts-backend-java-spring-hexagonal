package com.henriquericcio.contacts.external.api;

import lombok.Data;

@Data
public class AdvicePayload {
    private final String firstName;
    private final String phoneNumber;
    private final String lastName;
}

