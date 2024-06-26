package org.wastingnotime.contacts.inbound;

import org.wastingnotime.contacts.common.SelfValidating;
import org.wastingnotime.contacts.entities.Contact;
import lombok.EqualsAndHashCode;
import lombok.Value;

import javax.validation.constraints.NotNull;

public interface CreateContactUseCase {
    Contact.ContactId create(CreateContactCommand command);

    @Value
    @EqualsAndHashCode(callSuper = false)
    class CreateContactCommand extends SelfValidating<CreateContactCommand> {
        @NotNull String firstName;
        @NotNull String lastName;
        @NotNull String phoneNumber;

        public CreateContactCommand(String firstName, String lastName, String phoneNumber) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.phoneNumber = phoneNumber;
            //TODO: try AOP
            this.validateSelf();
        }
    }
}

