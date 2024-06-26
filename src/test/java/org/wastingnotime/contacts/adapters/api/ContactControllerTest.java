package org.wastingnotime.contacts.adapters.api;

import org.wastingnotime.contacts.adapters.api.query.ContactQuery;
import org.wastingnotime.contacts.entities.Contact;
import org.wastingnotime.contacts.inbound.CreateContactUseCase;
import org.wastingnotime.contacts.inbound.DeleteContactUseCase;
import org.wastingnotime.contacts.inbound.UpdateContactUseCase;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;

@WebMvcTest(ContactController.class)
public class ContactControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CreateContactUseCase createContactUseCase;

    @MockBean
    private DeleteContactUseCase deleteContactUseCase;

    @MockBean
    private UpdateContactUseCase updateContactUseCase;

    @MockBean
    private ContactQuery contactQuery;


    @Test
    void given_empty_payload_should_returns_400() throws Exception {
        mockMvc.perform(post("/contacts")
                .contentType(MediaType.APPLICATION_JSON)
                .content(""))
                .andExpect(status().isBadRequest());
    }

    @Test
    void given_valid_payload_should_returns_201() throws Exception {
        when(createContactUseCase.create(new CreateContactUseCase.CreateContactCommand("firstName", "lastName", "0000-0000")))
                .thenReturn(new Contact.ContactId("1234"));

        mockMvc.perform(post("/contacts")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"firstName\":\"firstName\",\"lastName\":\"lastName\",\"phoneNumber\":\"0000-0000\"}"))
                .andExpect(status().isCreated())
                .andExpect(header().stringValues("location","/1234"));
    }
}
