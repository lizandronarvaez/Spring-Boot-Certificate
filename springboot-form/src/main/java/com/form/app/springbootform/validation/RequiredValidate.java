package com.form.app.springbootform.validation;

import java.util.List;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

// Clase para crear una anotacion perosnalizada con la interfaz constraint
                                                    // NombreClase,CamposFormularios  
public class RequiredValidate implements ConstraintValidator<Required, String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        if (value.length() < 1 || value.isBlank() || value.isEmpty()) {
            return false;
        }
        return true;
    }

}
