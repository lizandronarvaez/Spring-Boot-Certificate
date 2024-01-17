package com.springbootexcepciones.services;

import java.util.Collection;
import java.util.Optional;

import com.springbootexcepciones.models.domain.User;

public interface IUserService {

    Optional<User> findById(Long id);

    Collection<User> findAlls();
}
