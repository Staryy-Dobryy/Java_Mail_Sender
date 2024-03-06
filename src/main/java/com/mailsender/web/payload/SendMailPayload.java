package com.mailsender.web.payload;

import com.mailsender.domain.services.requests.SendMailServiceRequest;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class SendMailPayload {
    @NotNull
    @NotEmpty
    private Integer userId;
    @NotNull
    @NotEmpty
    private String subject;
    @NotNull
    @NotEmpty
    private String text;

    public SendMailServiceRequest toRequest() { return new SendMailServiceRequest(userId, subject, text); }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
