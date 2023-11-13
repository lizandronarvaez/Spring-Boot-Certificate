package com.form.app.springbootform.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Role {
    
    private int id;
    private String nombre;
    private String role;
}
