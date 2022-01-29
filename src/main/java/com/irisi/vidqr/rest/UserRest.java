package com.irisi.vidqr.rest;

import com.irisi.vidqr.entity.UserEntity;
import com.irisi.vidqr.entity.VideoEntity;
import com.irisi.vidqr.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/vidqr/user")
public class UserRest {
    @Autowired
    private UserService userService;

    @GetMapping("/id/{id}")
    public UserEntity getUser(@PathVariable String id){
        return userService.findById(id);
    }

    @GetMapping("/allusers")
    public List<UserEntity> getAllUsers(){
        return userService.getAllUsers();
    }
}
