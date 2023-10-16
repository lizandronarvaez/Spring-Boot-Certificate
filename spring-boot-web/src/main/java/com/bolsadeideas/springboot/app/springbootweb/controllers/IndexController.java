package com.bolsadeideas.springboot.app.springbootweb.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bolsadeideas.springboot.app.springbootweb.model.Usuario;

@Controller
// Ruta principal para todos los metodos
@RequestMapping("/v1/api")
public class IndexController {
    // Un controlador va a tener metodos como toda clase
    // Todos los metodos de un controlador son publicos
    @GetMapping("/index")
    public String index(Model model) {
        model.addAttribute("titulo", "SpringBoot-Thymeleaf");
        model.addAttribute("message", "Curso SpringBoot Java MVC");
        // Las vistas tienen que llamarse como en nodejs
        return "index";
    }

    // en estos metodos se establecen los verbos http
    @GetMapping("/perfil")
    public String perfil(Model model) {
        // Instancia del modelo usuario
        Usuario usuario = new Usuario(null, null, null);
        // Atributtos que se acceden mediante la vista
        model.addAttribute("titulo", "SpringBoot-Thymeleaf");
        model.addAttribute("usuario", usuario);
        // Metodos setter para establecer datos del usuario
        usuario.setNombre("Lizandro");
        usuario.setApellido("Narváez");
        usuario.setEmail("lizandrojesus13@hotmail.com");
        // Nombre de la vista que estara en la carpeta templates
        return "perfil";
    }

    // en estos metodos se establecen los verbos http
    @GetMapping("/lista")
    public String lista(Model model) {
        // Atributtos que se acceden mediante la vista
        model.addAttribute("titulo", "SpringBoot-Thymeleaf");
        model.addAttribute("lista", "Lista de Usuarios");

        // Nombre de la vista que estara en la carpeta templates
        return "lista";
    }

    // Con esta anotacion se crea un modelo de atributo global que permite que todas las vistas puedan acceder
    @ModelAttribute("usuarios")
    public List<Usuario> userList() {
        // Instancia del modelo usuario
        // Agregar usuario a lista
        List<Usuario> usuarios = Arrays.asList(
                new Usuario("Marina", "Guillen Loyola", "m.guillenloyola@hotmail.com"),
                new Usuario("Jean Carlos", "Narváez Guillen", "jcarlosng@hotmail.com"),
                new Usuario("Lizandro", "Narvaez Moran", "lizandrojesus13@@hotmail.com"),
                new Usuario("Programacion", "Programador", "programador@hotmail.com"));

        return usuarios;
    }

}
