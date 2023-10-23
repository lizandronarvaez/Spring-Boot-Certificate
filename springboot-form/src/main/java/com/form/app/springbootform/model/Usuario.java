package com.form.app.springbootform.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

// Modelo de usuarios
public class Usuario {

    // Validacion de los campos con anotaciones @Anotacion

    private Integer id;

    @NotEmpty()
    private String nombre;

    @NotEmpty()
    private String apellido;

    @NotEmpty()
    private String username;

    @NotEmpty()
    @Size(message = "La contraseña debe tener minimo 6 caracteres", min = 6)
    private String password;

    @NotEmpty()
    @Email
    private String email;

    // Metodos getter y setter
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
