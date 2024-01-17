package com.springbootexcepciones.errorHandlerExceptions;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.springbootexcepciones.models.Error;

@RestControllerAdvice
public class HandlerExceptionController {

    @ExceptionHandler({ ArithmeticException.class })
    public ResponseEntity<Error> splitByZero(Exception exception) {
        Error error = new Error();
        error.setDate(new Date());
        error.setError("Error al dividir por 0");
        error.setMessage(exception.getMessage());
        error.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());

        // Primera forma de manejar un error
        // return ResponseEntity.internalServerError().body(error);

        // Segunda forma
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR.value()).body(error);
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<Error> notFoundPage(Exception exception) {
        Error error = new Error();
        error.setDate(new Date());
        error.setError("Pagina no encontrada");
        error.setMessage(exception.getMessage());
        error.setStatus(HttpStatus.NOT_FOUND.value());

        return ResponseEntity.status(error.getStatus()).body(error);
    }

    @ExceptionHandler(NumberFormatException.class)
    public Map<String, Object> numberFormatException(Exception exception) {
        Map<String, Object> errorMap = new HashMap<>();
        boolean data = false;
        if (data) {
            errorMap.put("ok", true);
            errorMap.put("data", data);
            return errorMap;
        }
        errorMap.put("error", "Hubo un error al realizar la operacion");
        errorMap.put("status", HttpStatus.NOT_FOUND.value());

        return errorMap;
    }

    @ExceptionHandler(UserNotFoundException.class)
    public Map<String, Object> userNotFoundException(Exception exception) {
        Map<String, Object> errorMap = new HashMap<>();
        errorMap.put("error", "No se encontro del usuario");
        errorMap.put("status", HttpStatus.NOT_FOUND.value());
        return errorMap;
    }
}
