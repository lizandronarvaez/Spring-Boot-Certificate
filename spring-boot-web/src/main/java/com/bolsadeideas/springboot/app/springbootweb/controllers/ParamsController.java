package com.bolsadeideas.springboot.app.springbootweb.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/v1/api/params")
public class ParamsController {

    @GetMapping("/")
    public String param(Model model) {
        model.addAttribute("titulo", "SpringBoot-Thymeleaf");
        model.addAttribute("message", "Parametros Url");

        return "params/index";
    }

    @GetMapping("/string")
    public String string(@RequestParam(required = false) String texto, Model model) {
        model.addAttribute("titulo", "SpringBoot-Thymeleaf");
        model.addAttribute("message", "Parametros Url");

        model.addAttribute("paramResult", texto);
        return "params/words";
    }

    // primera forma de capturar varios parametros
    @GetMapping("/someParams")
    public String someParams(@RequestParam String saludo, @RequestParam Integer numero, Model model) {
        model.addAttribute("titulo", "SpringBoot-Thymeleaf");
        model.addAttribute("message", "Parametros Url");

        model.addAttribute("paramResult", saludo + " " + numero);
        return "params/words";
    }

    // segunda forma de capturar varios parametros
    @GetMapping("/someParams2")
    public String someParams2(HttpServletRequest req, Model model) {
        model.addAttribute("titulo", "SpringBoot-Thymeleaf");
        model.addAttribute("message", "Parametros Url");

        // Acceder a los parametros de la url
        String saludo = req.getParameter("saludo");
        Integer numero;

        // Aplicar un try catch para comprobar que no existe un error
        try {
            numero = Integer.parseInt(req.getParameter("numero"));
        } catch (NumberFormatException e) {
            numero = 0;
        }
        model.addAttribute("paramResult", saludo + " " + numero);
        return "params/words";
    }
}
