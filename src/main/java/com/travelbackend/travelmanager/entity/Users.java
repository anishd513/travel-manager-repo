package com.travelbackend.travelmanager.entity;

import lombok.Data;
import java.io.Serializable;
import java.sql.Timestamp;

import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.*;

@Data
@Entity
@Table(name = "Users")
@Accessors(chain = true)
@NoArgsConstructor
public class Users {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="userId")
    private String userId;
    @Column(name = "mail_id")
    private String mailId;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "password")
    private String password;
    @CreationTimestamp
    @Column(name = "created_at")
    private Timestamp createdAt;
    
}
