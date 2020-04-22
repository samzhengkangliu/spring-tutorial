package com.spring5tutorial.sam.photoappapiusers.data.repository;

import com.spring5tutorial.sam.photoappapiusers.entity.UserEntity;

import org.springframework.data.repository.CrudRepository;

public interface UsersRepository extends CrudRepository<UserEntity, Long> {
    UserEntity findByEmail(String email);
}