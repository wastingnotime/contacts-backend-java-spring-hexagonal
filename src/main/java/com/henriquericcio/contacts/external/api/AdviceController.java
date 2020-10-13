package com.henriquericcio.contacts.external.api;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/advices")
@RequiredArgsConstructor
public class AdviceController {
    @PostMapping
    public ResponseEntity<?> newAdvice(@RequestBody AdvicePayload advicePayload) {
        log.info("Receiving payload {}",advicePayload);
        return ResponseEntity.accepted().build();
    }
}