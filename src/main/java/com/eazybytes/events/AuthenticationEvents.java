package com.eazybytes.events;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.security.authentication.event.AbstractAuthenticationFailureEvent;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class AuthenticationEvents {

    @EventListener
    public void onSuccess(AuthenticationSuccessEvent authenticationSuccessEvent) {
        log.info("Login Successful for user: {}", authenticationSuccessEvent.getAuthentication().getName());
    }

    @EventListener
    public void onFailure(AbstractAuthenticationFailureEvent abstractAuthenticationFailureEvent) {
        log.error("Login failed for user: {} due to {}", abstractAuthenticationFailureEvent.getAuthentication().getName(),
                abstractAuthenticationFailureEvent.getException().getMessage());
    }
}
