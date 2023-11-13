package com.form.app.springbootform.model;

import java.util.Date;
import java.util.List;
import com.form.app.springbootform.validation.Required;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// Modelo de usuarios
// Para etablabecer lombok se usa anotaciones
// Genera un constructor sin argumento
// @NoArgsConstructor
// Genera un contructor con el nombre de cada campo de la clase usuario
// @AllArgsConstructor

@Getter
@Setter
@NoArgsConstructor
public class Usuario {

    // Validacion de los campos con anotaciones @Anotacion
    // @ValidateUUID()
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
    @Size(min = 6)
    private String password;

    @Required
    @Email
    private String email;

    @Max(value = 65)
    @Min(value = 18)
    @NotNull()
    private Integer edad;

    // Validar fechas
    // Formato para almacenar en BD con input date
    // @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull
    @Past
    private Date fechaNacimiento;

    // Esta anotacion valida objetos relacionados
    // @Valid
    @NotNull
    private Pais pais;

    // Roles
    @NotEmpty
    private List<Role> roles;

}
