package com.mailsender.domain.services.requests;

public class DeleteUserServiceRequest {
    private Integer id;

    public DeleteUserServiceRequest(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


}
