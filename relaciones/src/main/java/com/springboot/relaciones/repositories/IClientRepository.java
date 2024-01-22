package com.springboot.relaciones.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.springboot.relaciones.entities.Clients;

public interface IClientRepository extends CrudRepository<Clients, Long> {

    @Query("SELECT c from Clients c left join fetch c.addresses where c.id=?1")
    Optional<Clients> findOneWithAddresses(Long id);

    @Query("SELECT c from Clients c left join fetch c.invoices where c.id=?1")
    Optional<Clients> findOneWithInvoices(Long id);

    @Query("SELECT c from Clients c left join fetch c.invoices left join fetch c.addresses where c.id=?1")
    Optional<Clients> findOne(Long id);
}
