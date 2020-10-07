package com.henriquericcio.contacts.application;

import com.henriquericcio.contacts.inbound.CreateContactUseCase;
import com.henriquericcio.contacts.outbound.SaveContact;
import lombok.val;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class CreateContactServiceTest {
    @InjectMocks
    CreateContactService createContactService;

    @Mock
    SaveContact saveContact;

    @Test
    public void given_null_command_should_returns_exception(){
        assertThatThrownBy(() -> createContactService.create(null)).isInstanceOf(NullPointerException.class);
    }

    @Test
    public void given_valid_command_should_save_contact_with_id(){
        val command = new CreateContactUseCase.CreateContactCommand("first", "last","0000-0000");

        val contactId = createContactService.create(command);

        assertThat(contactId).isNotNull();
        assertThat(contactId.getValue()).isNotNull();

        verify(saveContact, times(1)).save(any());
    }
}
