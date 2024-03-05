package com.mailsender.domain.model.user;

public class PublicUserModel {
    private String email;
    private String username;

    public PublicUserModel(UserModel user) {
        this.email = user.getEmail();
        this.username = user.getUsername();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
