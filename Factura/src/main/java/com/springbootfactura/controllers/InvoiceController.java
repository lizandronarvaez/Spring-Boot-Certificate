package com.springbootfactura.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.springbootfactura.models.Invoice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("invoices")
public class InvoiceController {

    @Autowired
    private Invoice invoice;

    @GetMapping()
    public Invoice showInvoice() {
        return this.invoice;
    }
}
