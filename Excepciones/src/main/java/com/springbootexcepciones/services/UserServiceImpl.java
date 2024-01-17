package com.springbootexcepciones.services;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbootexcepciones.models.domain.User;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    Collection<User> users;

    // // Busca por id
    // @Override
    // public Optional<User> findById(Long id) {

    // User user = null;
    // // Recorremos cada uno de los datos
    // for (User u : users) {
    // // Preguntamos si alguno de los id es igual al que pasamos por parametros
    // if (u.getId().equals(id)) {
    // // Los almacenamos en la variable
    // user = u;
    // // Salimos del for
    // break;
    // }
    // }

    // // Retornamos user
    // return Optional.ofNullable(user);
    // }

    // Busca por id
    @Override
    public Optional<User> findById(Long id) {
        return this.users.stream().filter((user) -> user.getId().equals(id)).findFirst();
    }

    // Devuelve una lista de datos
    @Override
    public Collection<User> findAlls() {
        return this.users;
    }

}
