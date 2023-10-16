package com.springboot.injection_dependency.app;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.springboot.injection_dependency.app.models.service.IServicio;
import com.springboot.injection_dependency.app.models.service.MiServicio;
import com.springboot.injection_dependency.app.models.service.MiServicio2;

@Configuration
public class AppConfig {

    @Bean("primerServicio")
    public IServicio registraServicio() {
        return new MiServicio();
    }
    
    @Bean("servicioOpcional")
    public IServicio registraServicioComplejo() {
        return new MiServicio2();
    }
}
