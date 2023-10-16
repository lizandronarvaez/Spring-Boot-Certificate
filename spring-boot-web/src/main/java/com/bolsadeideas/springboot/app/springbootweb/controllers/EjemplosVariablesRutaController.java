package com.bolsadeideas.springboot.app.springbootweb.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/variables")
public class EjemplosVariablesRutaController {

    // Obtener el parametro o valor de una ruta
    @GetMapping("/string/{texto}")
    public String variables(@PathVariable String texto, Model model) {
        model.addAttribute("titulo", "Recibir parametros con la anotacion @Path variable");
        model.addAttribute("paramResult", "El texto enviado en la ruta es:".concat(texto));
        return "variables/ver";

    }

    // Obetener dos o mas parametros o valores de una ruta
    @GetMapping("/string/{texto}/{numero}")
    public String variables(@PathVariable String texto, @PathVariable Integer numero, Model model) {
        model.addAttribute("titulo", "Recibir parametros con la anotacion @Path variable");
        model.addAttribute("paramString", texto);
        model.addAttribute("paramNumero", numero);

        return "variables/ver";
    }
}
