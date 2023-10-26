package com.form.app.springbootform.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

// Se crea una clase y se implenmenta constraint
public class ValidadorValidateUUID implements ConstraintValidator<ValidateUUID, Integer> {

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {

        // Se añade la condicion o el match
        if (value == 123456789 ) {
            return true;
        }
        return false;
    }

}
