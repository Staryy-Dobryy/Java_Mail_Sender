package com.mailsender.domain.model.user.exceptions;

public class UsernameExistsException extends RegistrationException {
    public UsernameExistsException() {
        super("Email address already exist");
    }
}