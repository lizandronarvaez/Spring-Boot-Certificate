package com.springboot.aopprogramacionorientadaaspecto.controllers;

import java.util.Collections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.springboot.aopprogramacionorientadaaspecto.services.GreetingServiceImpl;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/greeting")
@Slf4j
public class GreetingController {

    @Autowired
    private GreetingServiceImpl greetingServiceImpl;

    @GetMapping("/say")
    public ResponseEntity<?> greeting() {
        return ResponseEntity.ok(
                Collections.singletonMap("greeting", this.greetingServiceImpl.sayHello("Lizandro", "Hola como estas")));
    }

    @GetMapping("/error")
    public ResponseEntity<?> greetingError() {
        return ResponseEntity.ok(
                Collections.singletonMap("greeting", this.greetingServiceImpl.sayHelloError("Lizandro", "Hola como estas")));
    }
}
