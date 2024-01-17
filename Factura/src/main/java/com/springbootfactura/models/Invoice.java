package com.springbootfactura.models;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.Data;

@Data
@Component
public class Invoice {

    @Autowired
    private Client client;

    @Value("${invoice.description}")
    private String description;

    @Autowired
    private List<Item> items;

    public int getTotalInvoice() {
        // int total = 0;
        // for (Item item : items) {
        // total += item.getTotal();
        // }

        return items.stream()
                .map((item) -> item.getTotal())
                .reduce(0, (sum, amount) -> sum + amount);
    }

    public Invoice(){
        System.out.println("Creando el componnte invoice");
        // System.out.println(client);
    }

    @PostConstruct
    public void init(){
        System.out.println("Creando el componente de la Factura con @PostConstruct");
        System.out.println(client.toString());
    }

    // Se utiliza para realizar una accion despues de que el contructor se haya construido
    @PreDestroy
    public void destroy(){
        System.out.println("Destruyendo el componente invoice con @PreDestroy");
    }
}
