package com.spring5tutorial.sam.mobileappws.service;

import java.util.HashMap;
import java.util.Map;

import com.spring5tutorial.sam.mobileappws.dto.UserDetailsRequest;
import com.spring5tutorial.sam.mobileappws.model.User;
import com.spring5tutorial.sam.mobileappws.shared.Utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    Map<String, User> users;
    Utils utils;

    public UserServiceImpl() {}

    @Autowired
    public UserServiceImpl(Utils utils) {
        this.utils = utils;
    }

    @Override
    public User createUser(UserDetailsRequest userDetails) {
        
        User newUser = new User();
        newUser.setEmail(userDetails.getEmail());
        newUser.setFirstName(userDetails.getFirstName());
        newUser.setLastName(userDetails.getLastName());

        String userId = utils.generateUserId();
        newUser.setUserId(userId);

        if (users == null) users = new HashMap<>();
        users.put(userId, newUser);
        
        return newUser;
        
    }

    
}