package com.midmerchant.midmerchantbackend.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String username;
    private String email;

    public UserEntity(long id, String username, String email) {
        this.id = id;
        this.username = username;
        this.email = email;
    }

    public UserEntity() {
    }
}
