package com.springboot.relaciones.repositories;

import org.springframework.data.repository.CrudRepository;

import com.springboot.relaciones.entities.Invoice;

public interface IInvoiceRepository extends CrudRepository<Invoice, Long> {

}
