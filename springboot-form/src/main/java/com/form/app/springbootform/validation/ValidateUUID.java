package com.form.app.springbootform.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

//Este metodo sirve para valida un uuid
// Tambien sirve oara crear validaciones personalizadas
@Constraint(validatedBy = ValidadorValidateUUID.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.FIELD, ElementType.METHOD })
public @interface ValidateUUID {

    // Mensaje de error si el identificador no es valido
    String message() default "Identificador inválido";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
