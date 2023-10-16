package com.springboot.injection_dependency.app.models.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

// Anotacion que describe que es un servicio
// @Service("servicioOpcional")
// @Primary

public class MiServicio2 implements IServicio {
    // Los servicios se pueden implementar direcamente como atributos o en el metodo

    // Override significa que implementa un metodo de un padre
    @Override
    public String mostrarMensaje() {
        return "Llamando al proceso y ejecutandolo mediante la interfaz de forma complicada...";
    }

}
