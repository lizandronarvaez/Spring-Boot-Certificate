package com.springbootexcepciones.controllers;

import java.util.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;

import com.springbootexcepciones.errorHandlerExceptions.UserNotFoundException;
import com.springbootexcepciones.models.domain.User;
import com.springbootexcepciones.services.UserServiceImpl;


@RestController
@RequestMapping("/app")
public class AppControllers {

    @Autowired
    private UserServiceImpl userServiceImpl;

    @GetMapping
    public Collection<User> findAllUser() {
        return this.userServiceImpl.findAlls();
    }

    @GetMapping("/{id}")
    public User findById(@PathVariable Long id) {
        return this.userServiceImpl.findById(id).orElseThrow(()->new UserNotFoundException("No se encontro el usuario"));
    }
}
