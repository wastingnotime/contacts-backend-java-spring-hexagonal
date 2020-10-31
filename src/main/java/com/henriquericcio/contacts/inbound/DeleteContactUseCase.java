package com.henriquericcio.contacts.inbound;

import com.henriquericcio.contacts.common.SelfValidating;
import com.henriquericcio.contacts.entities.Contact;
import com.henriquericcio.contacts.inbound.common.NotFoundException;
import lombok.EqualsAndHashCode;
import lombok.Value;

import javax.validation.constraints.NotNull;

public interface DeleteContactUseCase {
    void delete(DeleteContactCommand command) throws NotFoundException;

    @Value
    @EqualsAndHashCode(callSuper = false)
    class DeleteContactCommand extends SelfValidating<DeleteContactCommand> {
        @NotNull String id;

        public DeleteContactCommand(String id) {
            this.id = id;
            this.validateSelf();
        }
    }
}
