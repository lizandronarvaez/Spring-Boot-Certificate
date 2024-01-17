package com.springboot.injection_dependency.app;

import java.util.*;
import org.springframework.context.annotation.*;
import com.springboot.injection_dependency.app.models.domain.*;
import com.springboot.injection_dependency.app.models.service.*;

@Configuration
public class AppConfig {

    @Bean("primerServicio")
    IServicio registraServicio() {
        return new MiServicio();
    }

    @Bean("servicioOpcional")
    IServicio registraServicioComplejo() {
        return new MiServicio2();
    }

    @Bean("itemsFactura")
    List<ItemFactura> registrarItems() {
        Producto producto1 = new Producto("Consola PS5", 499);
        Producto producto2 = new Producto("Volskwagen Passat", (int) 10.000);

        ItemFactura linea1 = new ItemFactura(producto1, 4);
        ItemFactura linea2 = new ItemFactura(producto2, 1);

        return Arrays.asList(linea1, linea2);
    }

    @Bean("itemsFacturaOficina")
    List<ItemFactura> registrarItemsOficina() {
        Producto producto1 = new Producto("Monitor LG", 499);
        Producto producto2 = new Producto("Portatil MSI", (int) 1.200);
        Producto producto3 = new Producto("Mesa Escritorio Gamming", 180);

        ItemFactura linea1 = new ItemFactura(producto1, 2);
        ItemFactura linea2 = new ItemFactura(producto2, 2);
        ItemFactura linea3 = new ItemFactura(producto3, 1);

        return Arrays.asList(linea1, linea2, linea3);
    }
}
