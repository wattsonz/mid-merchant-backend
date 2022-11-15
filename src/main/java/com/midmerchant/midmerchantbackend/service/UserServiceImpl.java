package com.midmerchant.midmerchantbackend.service;

import com.midmerchant.midmerchantbackend.entity.UserEntity;
import com.midmerchant.midmerchantbackend.model.User;
import com.midmerchant.midmerchantbackend.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User saveUser(User user) {
        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(user, userEntity);
        userRepository.save(userEntity);
        user.setId(userEntity.getId());

        return user;
    }

    @Override
    public List<User> getAllUsers() {
        List<UserEntity> userEntities = userRepository.findAll();
        return userEntities.stream()
                .map(userEntity -> new User(
                        userEntity.getId(),
                        userEntity.getUsername(),
                        userEntity.getEmail()
                ))
                .collect(Collectors.toList());
    }

    @Override
    public User getUserById(Long id) {
        UserEntity userEntity = userRepository.findById(id).get();
        User user = new User();
        BeanUtils.copyProperties(userEntity, user);

        return user;
    }

    @Override
    public User updateUser(Long id, User user) {
        UserEntity userEntity = userRepository.findById(id).get();
        userEntity.setUsername(user.getUsername());
        userEntity.setEmail(user.getEmail());
        userRepository.save(userEntity);
        user.setId(id);

        return user;
    }

    @Override
    public boolean deleteUser(Long id) {
        boolean isGetSucceed = userRepository.existsById(id);
        if (isGetSucceed) {
            UserEntity userEntity = userRepository.findById(id).get();
            userRepository.delete(userEntity);
            return true;
        } else {
            return false;
        }

    }
}
