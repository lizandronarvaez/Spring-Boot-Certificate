package com.form.app.springbootform.model;

import com.form.app.springbootform.validation.Required;
import com.form.app.springbootform.validation.ValidateUUID;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

// Modelo de usuarios
// Para etablabecer lombok se usa anotaciones

// Genera un constructor sin argumento
// @NoArgsConstructor

// Genera un contructor con el nombre de cada campo de la clase usuario
// @AllArgsConstructor

@Getter
@Setter
public class Usuario {

    // Validacion de los campos con anotaciones @Anotacion
    @ValidateUUID()
    private Integer id;

    // @NotEmpty()
    // @NotBlank(message = "El campo no puede estar vacio")
    @Required
    private String nombre;

    // @NotEmpty()
    @Required
    private String apellido;

    // @NotEmpty()
    // @NotBlank(message = "El campo no puede estar vacío")
    @Required
    private String username;

    // @NotEmpty()
    @Size(message = "La contraseña debe tener minimo 6 caracteres", min = 6)
    private String password;

    // @NotEmpty()
    @Email
    private String email;

    @Max(value = 65,message = "Debes tener maximo 65 años")
    @Min(value = 18,message = "Debes tener minimo 18 años")
    @NotNull(message = "Campo obligatorio")
    private Integer edad;

    // Metodos getter y setter
    /**
     * Los metodos getter y setter son generados con lombok,
     * es la magia de spring, con lombok se usan las anotaciones
     * 
     * @Getter y @Setter y con ellos a traves del usuario se puede
     *         ir jugando con los valores
     */
}
