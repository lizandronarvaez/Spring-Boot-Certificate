package com.springboot.springbootjpa.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.*;
import lombok.Data;

@Embeddable
@Data
public class Audit {

    @Column(name = "create_at")
    private LocalDateTime creatAt;
    @Column(name = "update_at")
    private LocalDateTime updateAt;

    @PrePersist
    public void prePersist() {
        System.out.println("Evento del ciclo de vida del entity con prePersist");
        this.creatAt = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate() {
        System.out.println("Evento del ciclo de vida del entity con preUpdate");
        this.updateAt = LocalDateTime.now();
    }
}
