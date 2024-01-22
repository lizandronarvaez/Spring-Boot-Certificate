package com.springboot.relaciones.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
@Table(name = "clients_details")
public class ClientDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private boolean premium;
    private Integer points;

    @OneToOne
    @JoinColumn(name="id_clients_details")
    private Clients clients;
}
