package com.form.app.springbootform.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

// En constraint va el nombre del validador
@Constraint(validatedBy = RequiredValidate.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.FIELD, ElementType.METHOD })
public @interface Required {

    // Mensaje de error si el identificador no es valido
    String message() default "El campo es obligatorio";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
