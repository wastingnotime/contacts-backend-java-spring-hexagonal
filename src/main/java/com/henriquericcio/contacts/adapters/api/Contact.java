package com.henriquericcio.contacts.adapters.api;

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
public class Contact {
    @Id
    private String id;
    private String firstName;
    private String phoneNumber;
    private String lastName;
}