package com.spring5tutorial.sam.photoappapiusers.service;

import com.spring5tutorial.sam.photoappapiusers.data.dto.UserDto;

public interface UsersService {
    UserDto createUser(UserDto userDetails);
    
}