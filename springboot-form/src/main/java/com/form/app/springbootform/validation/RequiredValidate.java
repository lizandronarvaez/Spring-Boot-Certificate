package com.form.app.springbootform.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class RequiredValidate implements ConstraintValidator<Required, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        if (value.length() < 1 || value.isBlank() || value.isEmpty()) {
            return false;
        }
        return true;
    }

}
