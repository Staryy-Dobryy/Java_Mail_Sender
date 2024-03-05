package com.mailsender.domain.model.user.exceptions;

public class UserNotFoundException extends Exception{
    public UserNotFoundException(String login) {
        super("No user found by `" + login);
    }
}
