package org.wastingnotime.contacts.adapters.persistence;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

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
}