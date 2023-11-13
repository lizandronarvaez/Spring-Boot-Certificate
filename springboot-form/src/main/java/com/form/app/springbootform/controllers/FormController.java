package com.form.app.springbootform.controllers;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.form.app.springbootform.editors.DataUpperCase;
import com.form.app.springbootform.editors.PaisPropertyEditor;
import com.form.app.springbootform.editors.RolePropertyEditor;
import com.form.app.springbootform.model.Pais;
import com.form.app.springbootform.model.Role;
import com.form.app.springbootform.model.Usuario;
import com.form.app.springbootform.services.PaisService;
import com.form.app.springbootform.services.RoleService;
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

    // Inyecciones por campo con @autowired
    @Autowired
    private UserValidation userValidation;

    @Autowired
    private PaisService paisService;

    @Autowired
    private PaisPropertyEditor paisPropertyEditor;

    @Autowired
    private RoleService roleService;

    @Autowired
    private RolePropertyEditor rolePropertyEditor;

    // Otra forma de validar automaticamente con anotaciones
    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        // Se establecer validar a initBinder
        // webDataBinder.setValidator(userValidation);

        // Agregar un nuevo validar y con eso no pierde las validaciones con anotaciones
        // webDataBinder.addValidators(userValidation);

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
        dateFormat.setLenient(false);

        webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));

        // Primer se pasa por parametro el tipo de dato,segundo argumento nombre de
        // campo de modelo
        // por ultimo la clase de el metodo
        webDataBinder.registerCustomEditor(String.class, new DataUpperCase());

        // mapeo campo pais
        webDataBinder.registerCustomEditor(Pais.class, "pais", paisPropertyEditor);

        // mapeo campo role
        webDataBinder.registerCustomEditor(Role.class, "roles", rolePropertyEditor);

    }

    // Lista de pais con LIST
    @ModelAttribute("paises")
    public List<String> paises() {
        return Arrays.asList("España", "Mexico", "Chile", "Ecuador", "Francia", "Alemania");
    }

    // Lista de paises con hasmap
    @ModelAttribute("paisesMap")
    public Map<String, String> paisesMap() {

        Map<String, String> paises = new HashMap<String, String>();

        paises.put("ES", "España");
        paises.put("FR", "Francia");
        paises.put("ECU", "Ecuador");
        paises.put("EEUU", "Estados Unidos");

        return paises;
    }

    // Lista de pais con modelo de pais
    @ModelAttribute("listaPaises")
    public List<Pais> listaPaises() {
        return paisService.listAll();
    }

    // roles usuarios con un arralist
    @ModelAttribute("listaRoles")
    public List<String> listaRoles() {
        List<String> roles = new ArrayList<>();

        roles.add("Admin");
        roles.add("User");
        roles.add("SuperUser");

        return roles;
    }

    // roles usuarios con un hasmap
    @ModelAttribute("listaRolesMap")
    public Map<String, String> listaRolesMap() {
        Map<String, String> roles = new HashMap<String, String>();

        roles.put("Administrador", "admin");
        roles.put("Usuario", "user");

        return roles;
    }

    // Roles con un objeto rol
    @ModelAttribute("listaRolesObject")
    public List<Role> listaRolesObject() {
        return this.roleService.findAll();
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
        model.addAttribute("registroUsuarios", "Usuarios Registrados");
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
