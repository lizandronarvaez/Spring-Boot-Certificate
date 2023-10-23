package com.springboot.injection_dependency.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springboot.injection_dependency.app.models.domain.Factura;

@Controller
@RequestMapping("/api/factura")
public class FacturaController {

    @Autowired
    private Factura factura;

    // Ver detalles
    @GetMapping("/ver")
    public String verFactura(Model model) {
        model.addAttribute("titulo", "Curso Spring Boot 2023");
        model.addAttribute("factura", factura);

        return "factura/ver";
    }
}
