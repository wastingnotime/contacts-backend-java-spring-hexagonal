package com.henriquericcio.contacts.adapters.api;

import com.henriquericcio.contacts.inbound.CreateContactUseCase;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping("/contacts")
@RequiredArgsConstructor
public class ContactController {
    private final CreateContactUseCase createContactUseCase;

    @PostMapping
    public ResponseEntity<?> addContact(@RequestBody ContactPayload contact) {
        val command = new CreateContactUseCase.CreateContactCommand(contact.getFirstName(), contact.getLastName(), contact.getPhoneNumber());
        val contactId = createContactUseCase.create(command);
        return ResponseEntity.created(URI.create("/" + contactId.getValue())).build();
    }
}