package com.springboot.injection_dependency.app;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.springboot.injection_dependency.app.models.domain.ItemFactura;
import com.springboot.injection_dependency.app.models.domain.Producto;
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

    @Bean("itemsFactura")
    public List<ItemFactura> registrarItems() {
        Producto producto1 = new Producto("Consola PS5", 499);
        Producto producto2 = new Producto("Volskwagen Passat", (int) 10.000);

        ItemFactura linea1 = new ItemFactura(producto1, 4);
        ItemFactura linea2 = new ItemFactura(producto2, 1);

        return Arrays.asList(linea1, linea2);
    }

    @Bean("itemsFacturaOficina")
    public List<ItemFactura> registrarItemsOficina() {
        Producto producto1 = new Producto("Monitor LG", 499);
        Producto producto2 = new Producto("Portatil MSI", (int) 1.200);
        Producto producto3 = new Producto("Mesa Escritorio Gamming", 180);

        ItemFactura linea1 = new ItemFactura(producto1, 2);
        ItemFactura linea2 = new ItemFactura(producto2, 2);
        ItemFactura linea3 = new ItemFactura(producto3, 1);

        return Arrays.asList(linea1, linea2, linea3);
    }
}
