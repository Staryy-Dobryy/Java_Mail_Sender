package com.mailsender.web.payload;

import com.mailsender.domain.services.requests.UpdateUserServiceRequest;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UpdateUserPayload {
    @NotNull
    @NotEmpty
    private Integer id;
    @Size(min = 3, max = 30, message = "Invalid username")
    @NotNull
    @NotEmpty
    private String username;

    @Email(message = "Invalid email")
    @NotNull
    @NotEmpty
    private String email;

    public UpdateUserServiceRequest toRequest(){
        return new UpdateUserServiceRequest(id, username, email);
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
