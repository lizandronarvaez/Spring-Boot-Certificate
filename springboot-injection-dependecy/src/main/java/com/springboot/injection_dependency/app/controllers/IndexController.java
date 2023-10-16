package com.springboot.injection_dependency.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.springboot.injection_dependency.app.models.service.IServicio;

@Controller
public class IndexController {
    // // Creando un atributo para implementar el servicio
    // private MiServicio servicio = new MiServicio();

    // Con autowired no hace falta instanciar la clase
    @Autowired
    @Qualifier("servicioOpcional")
    private IServicio servicio;

    // Inyecion por contructor no hace falta implementar autowired
    // public IndexController(IServicio servicio) {
    //     this.servicio = servicio;
    // }

    // Metodo get para retornar una vista
    @GetMapping({ "/", "", "/index" })
    public String index(Model model) {
        model.addAttribute("titulo", "Java: Inyeccion de depedencias");

        model.addAttribute("inyeccionServicio", servicio.mostrarMensaje());

        return "index";
    }

}
