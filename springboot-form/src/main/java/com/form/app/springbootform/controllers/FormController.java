package com.form.app.springbootform.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.form.app.springbootform.model.Usuario;
import com.form.app.springbootform.validation.UserValidation;

import jakarta.validation.Valid;

@Controller
// Persirtis los datos
@SessionAttributes("usuario")
@RequestMapping("/v1/api")
public class FormController {
    /**
     * Para validar con el validar nativo de spring Validator
     * se establece un modelo de validador y se inyecta en el controlador.
     * !!EN EL MODELO NO!!
     */
    // Inyectar el validador
    @Autowired
    private UserValidation userValidation;

    // Otra forma de validar automaticamente con anotaciones
    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        // Se establecer validar a initBinder
        // webDataBinder.setValidator(userValidation);

        // Agregar un nuevo validar y con eso no pierde las validaciones con anotaciones
        // webDataBinder.addValidators(userValidation);
    }

    // Pasar los datos a la vista y retornar la vista
    @GetMapping("/form")
    public String form(Model model) {
        // instancia usuario
        Usuario usuario = new Usuario();
        // Titulo pagina
        model.addAttribute("title", "Formulario con SpringBoot");

        // Datos modelo
        model.addAttribute("usuario", usuario);

        // Datos formulario
        usuario.setId(1);

        // vista formulario
        return "form";
    }

    @PostMapping("/form")
    // @Request body recoje todo los datos de forma que envia el nombre de los
    // campos y el valor
    // Con requestparam solo recoge el valor de los campos

    // Se puede mapear los campos del formulario pasando por argunemto el modelo de
    // usuario
    // y para validar los campos en el backend se usa bindingresult despues del
    // objeto que queremos validar

    public String submitForm(@Valid Usuario usuario, BindingResult bindingResul, Model model,
            SessionStatus sessionStatus) {

        // Validar los campos en el controllador con Validador
        // userValidation.validate(usuario, bindingResul);
        // Titulo pagina
        model.addAttribute("title", "Formulario con SpringBoot");

        // condicional
        if (bindingResul.hasErrors()) {
            // // Se crear un hasmap
            // Map<String, String> errores = new HashMap<>();

            // for (FieldError error : bindingResul.getFieldErrors()) {
            // errores.put(error.getField(),
            // "El campo ".concat(error.getField()).concat(" no puede estar vacio"));
            // }
            // model.addAttribute("error", errores);
            return "form";
        }
        // Datos del formulario
        model.addAttribute("usuario", usuario);
        // Se usa sesion status para persitir el dato y que no se borre
        sessionStatus.setComplete();
        return "formResult";
    }
}
