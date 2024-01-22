package com.springboot.relaciones.entities;

import jakarta.persistence.*;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "invoices")
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private Long total;

    // Muchas facturas estan asociadas a un cliente
    // le da el nombre a la llave foranea
    @JoinColumn(name = "id_client")
    @ManyToOne
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Clients client;
}
