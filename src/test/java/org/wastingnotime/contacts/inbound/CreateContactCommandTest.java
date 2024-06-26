package org.wastingnotime.contacts.inbound;

import lombok.val;
import org.junit.jupiter.api.Test;

import javax.validation.ConstraintViolationException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CreateContactCommandTest {

    @Test
    public void given_null_for_any_command_parameter_should_returns_exception(){
        assertThatThrownBy(()-> new CreateContactUseCase.CreateContactCommand(null,null,null)).isInstanceOf(ConstraintViolationException.class);
        assertThatThrownBy(()-> new CreateContactUseCase.CreateContactCommand(null,null,"")).isInstanceOf(ConstraintViolationException.class);
        assertThatThrownBy(()-> new CreateContactUseCase.CreateContactCommand(null,"",null)).isInstanceOf(ConstraintViolationException.class);
        assertThatThrownBy(()-> new CreateContactUseCase.CreateContactCommand(null,"","")).isInstanceOf(ConstraintViolationException.class);
        assertThatThrownBy(()-> new CreateContactUseCase.CreateContactCommand("",null,null)).isInstanceOf(ConstraintViolationException.class);
        assertThatThrownBy(()-> new CreateContactUseCase.CreateContactCommand("",null,"")).isInstanceOf(ConstraintViolationException.class);
        assertThatThrownBy(()-> new CreateContactUseCase.CreateContactCommand("","",null)).isInstanceOf(ConstraintViolationException.class);
    }

    @Test
    public void given_valid_command_should_save_contact_with_id(){
        val firstName = "firstName";
        val lastName = "lastName";
        val phoneNumber = "phoneNumber";

        val command = new CreateContactUseCase.CreateContactCommand(firstName,lastName,phoneNumber);

        assertThat(command).isNotNull();
        assertThat(command.getFirstName()).isEqualTo(firstName);
        assertThat(command.getLastName()).isEqualTo(lastName);
        assertThat(command.getPhoneNumber()).isEqualTo(phoneNumber);
    }
}
