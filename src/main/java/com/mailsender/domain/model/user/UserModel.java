package com.mailsender.domain.model.user;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Entity
@Table(name = "Users")
public class UserModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer Id;
    @Column(name = "email", nullable = false, unique = true)
    public String Email;
    @Column(name = "username", nullable = false)
    public String UserName;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "createdOn", nullable = false)
    public Date Date;
}