package com.henriquericcio.contacts.adapters.persistence;

import com.henriquericcio.contacts.entities.Contact;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Contact")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContactEntity {
    @Id
    private String id;
    private String firstName;
    private String phoneNumber;
    private String lastName;

    //TODO: SRP vs convenience
    public static ContactEntity of(Contact contact) {
        return new ContactEntity(
                contact.getId().getValue(),
                contact.getFirstName(),
                contact.getLastName(),
                contact.getPhoneNumber()
        );
    }
}