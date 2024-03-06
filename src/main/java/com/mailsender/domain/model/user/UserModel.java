package com.mailsender.domain.model.user;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Users")
public class UserModel {
    public UserModel(){}
    public UserModel(String username, String email) {

        this.username = username;
        this.email = email;
        this.createdOn = new Date();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "email", nullable = false, unique = true)
    private String email;
    @Column(name = "username", length = 30, nullable = false)
    private String username;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "createdOn", nullable = false)
    private Date createdOn;

    public Integer getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) { this.email = email; }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) { this.username = username; }

    public java.util.Date getDate() {
        return createdOn;
    }
}