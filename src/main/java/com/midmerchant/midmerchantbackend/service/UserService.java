package com.midmerchant.midmerchantbackend.service;

import com.midmerchant.midmerchantbackend.model.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);

    List<User> getAllUsers();

    User getUserById(Long id);

    User updateUser(Long id, User user);

    boolean deleteUser(Long id);
}
