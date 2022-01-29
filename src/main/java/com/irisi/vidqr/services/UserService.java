package com.irisi.vidqr.services;

import com.irisi.vidqr.entity.UserEntity;
import com.irisi.vidqr.entity.VideoEntity;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService {
    public UserEntity findById(String id);
    public List<UserEntity> getAllUsers();
}
