package com.midmerchant.midmerchantbackend.model;

import lombok.Data;

@Data
public class User {
    private long id;
    private String username;
    private String email;

    public User(long id, String username, String email) {
        this.id = id;
        this.username = username;
        this.email = email;
    }

    public User() {
    }
}
