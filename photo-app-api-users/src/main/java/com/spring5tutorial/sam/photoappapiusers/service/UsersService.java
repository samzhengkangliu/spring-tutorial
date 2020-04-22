package com.spring5tutorial.sam.photoappapiusers.service;

import com.spring5tutorial.sam.photoappapiusers.data.dto.UserDto;

import org.springframework.security.core.userdetails.UserDetailsService;

public interface UsersService extends UserDetailsService{
    UserDto createUser(UserDto userDetails);
    UserDto getUserDetailsByEmail(String email);
}