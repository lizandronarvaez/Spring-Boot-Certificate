package com.springboot.injection_dependency.app.models.domain;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.ApplicationScope;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import java.io.Serializable;

@Component
// @SessionScope
// @ApplicationScope
@RequestScope
public class Factura implements Serializable {

    private static final long serialVersionUID = 1L;

    @Value("${factura.descripcion}")
    private String descripcion;

    @Autowired
    private Cliente cliente;

    @Autowired
    @Qualifier("itemsFacturaOficina")
    private List<ItemFactura> items;

    // Metodos
    @PostConstruct
    public void inicializar() {
        cliente.setNombre("Marina");
        cliente.setApellido("Guillen");
        descripcion = "Factura a nombre de ".concat(cliente.getNombre().concat(" ").concat(cliente.getApellido()));
    }

    @PreDestroy
    public void destroy() {
        System.out.println(descripcion.concat(" destruyendose..."));
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<ItemFactura> getItems() {
        return items;
    }

    public void setItems(List<ItemFactura> items) {
        this.items = items;
    }
}
