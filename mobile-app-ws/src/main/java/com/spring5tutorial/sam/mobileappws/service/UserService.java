package com.spring5tutorial.sam.mobileappws.service;

import com.spring5tutorial.sam.mobileappws.dto.UserDetailsRequest;
import com.spring5tutorial.sam.mobileappws.model.User;

public interface UserService {
    User createUser(UserDetailsRequest userDetails);
}