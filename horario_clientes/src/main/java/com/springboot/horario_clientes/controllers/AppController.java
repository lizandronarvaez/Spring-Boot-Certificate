package com.springboot.horario_clientes.controllers;

import java.util.*;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/app")
@Slf4j
public class AppController {

    @GetMapping()
    public ResponseEntity<?> submit(HttpServletRequest request) {

        Map<String, Object> data = new HashMap<>();
        data.put("title", "Bienvenidos al sistema");
        data.put("horario", new Date());
        data.put("message", request.getAttribute("message"));
        return ResponseEntity.ok(data);
    }
}
