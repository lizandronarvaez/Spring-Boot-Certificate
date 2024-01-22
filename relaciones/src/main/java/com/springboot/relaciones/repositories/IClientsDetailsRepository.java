package com.springboot.relaciones.repositories;

import org.springframework.data.repository.CrudRepository;

import com.springboot.relaciones.entities.ClientDetails;
import com.springboot.relaciones.entities.Clients;

public interface IClientsDetailsRepository extends CrudRepository<Clients, Long> {

    void save(ClientDetails clientDetails);

}
