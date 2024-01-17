package com.bolsadeideas.springboot.app.springbootweb.controllers;

import java.util.*;
import org.springframework.web.bind.annotation.*;

import com.bolsadeideas.springboot.app.springbootweb.model.Usuario;

@RestController
@RequestMapping("/json")
public class ExampleRest {


    @GetMapping("/example-rest")
    public Map<String, String> jsonResponse() {
        Map<String, String> jsonRes = new HashMap<>();

        jsonRes.put("error", "404");
        jsonRes.put("saludo", "hola");
        jsonRes.put("tipoApi", "apiRest");

        return jsonRes;
    }

    @GetMapping("/lista")
    public List<Usuario> listarTodos() {
        Usuario user1 = new Usuario("Lizandro", "Narvaez", "lizandrojesus13@hotmail.com");
        Usuario user2 = new Usuario("Lizandro", "Narvaez", "lizandrojesus13@hotmail.com");
        Usuario user3 = new Usuario("Lizandro", "Narvaez", "lizandrojesus13@hotmail.com");
        List<Usuario> listUsers = new ArrayList<>();
        listUsers.add(user1);
        listUsers.add(user2);
        listUsers.add(user3);

        return listUsers;
    }
}
