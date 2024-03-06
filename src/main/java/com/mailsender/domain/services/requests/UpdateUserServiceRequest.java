package com.mailsender.domain.services.requests.user;

import org.springframework.util.Assert;

public class UpdateUserServiceRequest {
    private Integer id;
    private String username;
    private String email;
    public UpdateUserServiceRequest(Integer id, String username, String email) {
        Assert.hasText(username, "Parameter `username` must not be empty");
        Assert.hasText(email, "Parameter `email` must not be empty");

        this.id = id;
        this.username = username;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
