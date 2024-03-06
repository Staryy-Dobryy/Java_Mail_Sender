package com.mailsender.web.payload;

import com.mailsender.domain.services.requests.UpdateCornServiceRequest;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UpdateCornPayload {
    @Size(min = 5, max = 999, message = "Invalid expression")
    @NotNull
    @NotEmpty
    private String expression;
    @NotNull
    @NotEmpty
    private Integer userId;
    @NotNull
    @NotEmpty
    private String subject;
    @NotNull
    @NotEmpty
    private String text;

    public UpdateCornServiceRequest toRequest(){
        return new UpdateCornServiceRequest(expression, userId, subject, text);
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
