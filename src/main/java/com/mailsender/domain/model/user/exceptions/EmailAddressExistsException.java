package com.mailsender.domain.model.user.exceptions;

public class EmailAddressExistsException extends RegistrationException {
    public EmailAddressExistsException() {
        super("Email address already exist");
    }
}