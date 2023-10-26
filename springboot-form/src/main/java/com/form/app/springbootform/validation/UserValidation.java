package com.form.app.springbootform.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.form.app.springbootform.model.Usuario;

@Component
public class UserValidation implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {

        // Validamos que el objeto que vamos a validar es una clase
        return Usuario.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

        // Validar los campos del formulario con los campos del formulario
        Usuario usuario = (Usuario) target;

        // primera forma de validar un formulario
        // primer parametro errors,nombreCampo, y mensaje del campo
        // ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username",
        // "isRequired.usuario.username");

        // Segunda forma de validar un formulario
        // if (usuario.getNombre().isBlank()) {
        // errors.rejectValue("nombre", "NotEmpty");
        // ;
        // }
    }

}
