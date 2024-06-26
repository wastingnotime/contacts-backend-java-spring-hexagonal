package org.wastingnotime.contacts.application;

import org.wastingnotime.contacts.inbound.CreateContactUseCase;
import org.wastingnotime.contacts.outbound.DeleteContact;
import org.wastingnotime.contacts.outbound.SaveContact;
import org.wastingnotime.contacts.outbound.UpdateContact;
import lombok.val;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class CreateContactServiceTest {
    @InjectMocks
    ContactService contactService;

    @Mock
    SaveContact saveContact;

    @Mock
    DeleteContact deleteContact;

    @Mock
    UpdateContact updateContact;


    @Test
    public void given_null_command_should_returns_exception(){
        assertThatThrownBy(() -> contactService.create(null)).isInstanceOf(NullPointerException.class);
    }

    @Test
    public void given_valid_command_should_save_contact_with_id(){
        val command = new CreateContactUseCase.CreateContactCommand("first", "last","0000-0000");
        val contactId = contactService.create(command);

        Assertions.assertThat(contactId).isNotNull();
        assertThat(contactId.getValue()).isNotNull();
        assertThat(UUID.fromString(contactId.getValue())).isNotNull();

        verify(saveContact, times(1)).save(any());
    }
}
