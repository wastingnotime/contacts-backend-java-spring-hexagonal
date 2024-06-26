package org.wastingnotime.contacts.inbound;

import jakarta.validation.constraints.NotNull;
import org.wastingnotime.contacts.common.SelfValidating;
import org.wastingnotime.contacts.inbound.common.NotFoundException;
import lombok.EqualsAndHashCode;
import lombok.Value;

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
