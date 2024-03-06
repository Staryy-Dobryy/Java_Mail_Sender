package com.mailsender.domain.services.requests;

import org.springframework.util.Assert;

public class SendMailServiceRequest {
    private Integer userId;
    private String subject;
    private String text;

    public SendMailServiceRequest(Integer userId, String subject, String text) {
        Assert.hasText(subject, "Parameter `subject` must not be empty");
        Assert.hasText(text, "Parameter `text` must not be empty");

        this.userId = userId;
        this.subject = subject;
        this.text = text;
    }

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
