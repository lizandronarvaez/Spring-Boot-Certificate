package com.springbootexcepciones.data;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.springbootexcepciones.models.domain.RoleEnum;
import com.springbootexcepciones.models.domain.User;

@Configuration
public class Data {

    @Bean
    List<User> users() {
        // Se implementa en el constructor el array
        List<User> users = new ArrayList<>();

        // Se agrega los datos a traves del constructor
        users.add(new User(1L, "Lizandro", "Narvaez", RoleEnum.USER));
        users.add(new User(2L, "User2", "last2", RoleEnum.ADMIN));
        users.add(new User(3L, "User3", "last3", RoleEnum.ADMIN));
        users.add(new User(4L, "User4", "last4", RoleEnum.USER));
        return users;
    }
}
