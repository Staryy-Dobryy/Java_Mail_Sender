package com.mailsender.web.payload;

import com.mailsender.domain.services.requests.DeleteUserServiceRequest;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class DeleteUserPayload {
    @NotNull
    @NotEmpty
    private Integer id;

    public DeleteUserServiceRequest toRequest(){
        return new DeleteUserServiceRequest(id);
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
