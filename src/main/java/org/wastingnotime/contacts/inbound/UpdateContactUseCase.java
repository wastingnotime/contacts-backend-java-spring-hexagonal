package org.wastingnotime.contacts.inbound;

import org.wastingnotime.contacts.common.SelfValidating;
import org.wastingnotime.contacts.inbound.common.NotFoundException;
import lombok.EqualsAndHashCode;
import lombok.Value;

import javax.validation.constraints.NotNull;

public interface UpdateContactUseCase {
    void update(UpdateContactCommand command) throws NotFoundException;

    @Value
    @EqualsAndHashCode(callSuper = false)
    class UpdateContactCommand extends SelfValidating<UpdateContactCommand> {
        @NotNull String id;
        @NotNull String firstName;
        @NotNull String lastName;
        @NotNull String phoneNumber;

        public UpdateContactCommand(String id, String firstName, String lastName, String phoneNumber) {
            this.id = id;
            this.firstName = firstName;
            this.lastName = lastName;
            this.phoneNumber = phoneNumber;
            this.validateSelf();
        }
    }
}
