package com.henriquericcio.contacts.adapters.client;

import com.henriquericcio.contacts.entities.Contact;
import com.henriquericcio.contacts.outbound.AdviceExternalSystem;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Component
@RequiredArgsConstructor
public class ExternalSystemClientAdapter implements AdviceExternalSystem {
    @Override
    public void tell(Contact contact) {
        log.info("Trying to tell {}",contact.getId().getValue());

        val uri = "http://localhost:8010/advices";
        val restTemplate = new RestTemplate();

        restTemplate.postForLocation( uri, ExternalSystemPayload.of(contact));
    }
}
