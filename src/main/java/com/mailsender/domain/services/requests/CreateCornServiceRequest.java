package com.mailsender.domain.services.requests;

import org.springframework.util.Assert;

public class CreateCornServiceRequest {
    private String expression;
    private Integer userId;
    private String subject;
    private String text;

    public CreateCornServiceRequest(String expression, Integer userId, String subject, String text) {
        Assert.hasText(expression, "Parameter `expression` must not be empty");
        Assert.hasText(subject, "Parameter `subject` must not be empty");
        Assert.hasText(text, "Parameter `text` must not be empty");

        this.expression = expression;
        this.userId = userId;
        this.subject = subject;
        this.text = text;
    }

    public String getExpression() {
        return expression;
    }

    public void setExpression(String expression) {
        this.expression = expression;
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
