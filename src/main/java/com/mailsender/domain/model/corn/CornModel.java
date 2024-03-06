package com.mailsender.domain.model.corn;

import com.mailsender.domain.model.mail.MailMessageType;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "CornJobs")
public class CornModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "userId", nullable = false)
    private Integer userId;
    @Column(name = "expression", nullable = false)
    private String expression;
    @Column(name = "subject", nullable = false)
    private String subject;
    @Column(name = "text", nullable = false)
    private String text;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "createdOn", nullable = false)
    private Date createdOn;

    public CornModel() {

    }
    public CornModel(Integer userId, String expression, String subject, String text) {
        this.userId = userId;
        this.expression = expression;
        this.subject = subject;
        this.text = text;
        this.createdOn = new Date();
    }


    public Integer getUserId() {
        return userId;
    }

    public String getExpression() {
        return expression;
    }

    public String getSubject() {
        return subject;
    }

    public String getText() {
        return text;
    }

    public Date getCreatedOn() {
        return createdOn;
    }
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Integer getId() {
        return id;
    }
}
