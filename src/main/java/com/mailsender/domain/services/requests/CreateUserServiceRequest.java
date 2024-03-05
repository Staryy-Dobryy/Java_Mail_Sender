package com.mailsender.domain.services.requests;

import org.springframework.util.Assert;

public class CreateUserServiceRequest {
    private String username;
    private String email;
    public CreateUserServiceRequest(String username, String email) {
        Assert.hasText(username, "Parameter `username` must not be empty");
        Assert.hasText(email, "Parameter `email` must not be empty");

        this.username = username;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
