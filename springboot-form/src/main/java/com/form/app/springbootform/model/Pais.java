package com.form.app.springbootform.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// Constructor con parametros
@AllArgsConstructor
// Constructor sin parametros
@NoArgsConstructor
@Getter
@Setter
// Metodos getter-setter
public class Pais {

    private Integer id;
    private String codigo;
    private String nombre;

}
