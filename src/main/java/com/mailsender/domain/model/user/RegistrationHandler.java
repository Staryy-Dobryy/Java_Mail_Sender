package com.mailsender.domain.model.user;

import com.mailsender.domain.model.user.exceptions.EmailAddressExistsException;
import com.mailsender.domain.model.user.exceptions.RegistrationException;
import com.mailsender.domain.model.user.exceptions.UsernameExistsException;
import com.mailsender.infrastructure.repository.UserRepository;
import org.springframework.stereotype.Component;

@Component
public class RegistrationHandler {
    private UserRepository repository;

    public RegistrationHandler(UserRepository repository) {
        this.repository = repository;
    }
    public UserModel register(String username, String email) throws RegistrationException {

        UserModel existingUser = repository.findByUsername(username);
        if (existingUser != null) {
            throw new UsernameExistsException();
        }

        existingUser = repository.findByEmail(email.toLowerCase());
        if (existingUser != null) {
            throw new EmailAddressExistsException();
        }


        UserModel newUser = new UserModel(username, email);
        repository.save(newUser);
        return newUser;
    }
}
