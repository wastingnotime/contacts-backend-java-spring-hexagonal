package org.wastingnotime.contacts.entities;

import lombok.*;

import java.util.UUID;

//TODO: using UUID breaks the puretest domain
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Contact {
    @Getter
    private final ContactId id;
    @Getter
    @Setter
    private String firstName;
    @Getter
    @Setter
    private String phoneNumber;
    @Getter
    @Setter
    private String lastName;

    public Contact (String firstName,String lastName,String phoneNumber){
        this(new ContactId(UUID.randomUUID().toString()),firstName,lastName,phoneNumber);
    }

    @Value
    public static class ContactId {
        String value;
    }
}