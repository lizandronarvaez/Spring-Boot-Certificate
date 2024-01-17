package com.springbootfactura;

import java.util.*;

import org.springframework.context.annotation.*;
import com.springbootfactura.models.*;

@Configuration
@PropertySource(value = "classpath:data.properties", encoding = "UTF-8")
public class AppConfig {

    @Bean
    @Primary
    List<Item> itemsInvoceConsoles() {
        Product p1 = new Product("Consola PS5", 599);
        Product p2 = new Product("Auriculares Blueetooh Sony", 200);

        return Arrays.asList(new Item(p1, 2), new Item(p2, 3));
    }

    @Bean
    // @Primary
    List<Item> itemsInvoceHome() {
        Product p3 = new Product("Portatil HP", 1200);
        Product p4 = new Product("Home Cinema", 600);
        Product p5 = new Product("Television Samsung 78'", 1200);

        return Arrays.asList(new Item(p3, 2), new Item(p4, 1), new Item(p5, 2));
    }
}
