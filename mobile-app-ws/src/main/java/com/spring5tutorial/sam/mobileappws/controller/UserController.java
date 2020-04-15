package com.spring5tutorial.sam.mobileappws.controller;

import java.util.Map;

import javax.validation.Valid;

import com.spring5tutorial.sam.mobileappws.dto.UpdateUserDetailsRequest;
import com.spring5tutorial.sam.mobileappws.dto.UserDetailsRequest;
import com.spring5tutorial.sam.mobileappws.exception.UserServiceException;
import com.spring5tutorial.sam.mobileappws.model.User;
import com.spring5tutorial.sam.mobileappws.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    Map<String, User> users;

    @Autowired
    UserService userService;

    @GetMapping
    public String getUsers(@RequestParam(value = "page", defaultValue = "1") int page,
            @RequestParam(value = "limit", defaultValue = "50") int limit,
            // Provide defaultValue if query string param is not required, or it may cause
            // Null Pointer Exception
            @RequestParam(value = "sort", defaultValue = "desc", required = false) String sort) {
        return "get user was called with page =" + page + " and limit = " + limit + " and sort = " + sort;
    }

    // Support both JSON and XML format
    // ResponseEntity is for return http status with a status code
    @GetMapping(path = "/{userId}", produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<User> getUser(@PathVariable String userId) {
        if (users.containsKey(userId)) {
            return new ResponseEntity<>(users.get(userId), HttpStatus.OK);
        } else {
            throw new UserServiceException("A user service exception is thrown");
            // return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @PostMapping(consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }, produces = {
            MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
    // Add @Valid if you want to turn on validations
    // Dependency Injection of userService with @Autowired and @Service
    public ResponseEntity<User> createUser(@Valid @RequestBody UserDetailsRequest userDetails) {
        User newUser = userService.createUser(userDetails);
        return new ResponseEntity<User>(newUser, HttpStatus.OK);
    }

    @PutMapping(path = "/{userId}", consumes = { MediaType.APPLICATION_XML_VALUE,
            MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_XML_VALUE,
                    MediaType.APPLICATION_JSON_VALUE })
    public User updateUser(@Valid @PathVariable String userId, @RequestBody UpdateUserDetailsRequest userDetails) {
        User storedUser = users.get(userId);
        storedUser.setFirstName(userDetails.getFirstName());
        storedUser.setLastName(userDetails.getLastName());

        users.put(userId, storedUser);

        return storedUser;
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable String id) {
        users.remove(id);
        return ResponseEntity.noContent().build();
    }
}