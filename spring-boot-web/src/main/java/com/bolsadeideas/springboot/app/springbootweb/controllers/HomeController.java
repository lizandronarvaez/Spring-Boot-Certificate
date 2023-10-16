package com.bolsadeideas.springboot.app.springbootweb.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        // redirecciona a una ruta cambiando la ruta
        return "redirect:/v1/api/index";

        // Rediccion pero la ruta del navegador no la cambia
        // return "forward:/v1/api/index";

    }
}
