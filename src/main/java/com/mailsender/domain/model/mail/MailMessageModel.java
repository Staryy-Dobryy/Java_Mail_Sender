package com.mailsender.domain.model.mail;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "MailMessages")
public class MailMessageModel {
    public MailMessageModel() {
    }

    public MailMessageModel(Integer userId, MailMessageType type) {
        this.userId = userId;
        this.type = type;
        this.createdOn = new Date();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "userId", nullable = false)
    private Integer userId;
    @Column(name = "type", nullable = false)
    private MailMessageType type;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "createdOn", nullable = false)
    private Date createdOn;

    public Integer getId() {
        return id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public MailMessageType getType() {
        return type;
    }

    public void setType(MailMessageType type) {
        this.type = type;
    }

    public Date getСreatedOn() {
        return createdOn;
    }

}
