package com.irisi.vidqr.services.impl;

import com.irisi.vidqr.dao.UserRepository;
import com.irisi.vidqr.entity.CollectionEntity;
import com.irisi.vidqr.entity.UserEntity;
import com.irisi.vidqr.entity.VideoEntity;
import com.irisi.vidqr.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserEntity findById(String id) {
        Optional<UserEntity> userEntity = userRepository.findById(id);
        if(userEntity.isPresent())
            return userEntity.get();
        return null;
    }

    @Override
    public List<UserEntity> getAllUsers() {
        List<UserEntity> userEntities = userRepository.findAll();
        if (!userEntities.isEmpty())
            return userEntities;
        return null;
    }

}
