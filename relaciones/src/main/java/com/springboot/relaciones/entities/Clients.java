package com.springboot.relaciones.entities;

import java.util.*;
import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity
@Table(name = "clients")
public class Clients {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String lastname;

    // colocando joinColumn se crear una una llave foranea en la tabla address
    // Sino colocasemos eso crear una tabla independiente con una llave foranea de
    // cada tabla client y address
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "client_id")
    // Un cliente puede tener muchas direcciones
    private Set<Address> addresses;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "client", fetch = FetchType.EAGER)
    @Builder.Default
    private Set<Invoice> invoices = new HashSet<>();

    @OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL,orphanRemoval = true,mappedBy = "clients")
    @ToString.Exclude
    private ClientDetails clientDetails;


    public Clients addInvoice(Invoice invoice) {
        this.invoices.add(invoice);
        invoice.setClient(this);
        return this;
    }
}
