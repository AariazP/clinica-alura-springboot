package org.example.clinicaalura.exceptions;

import org.example.clinicaalura.dto.error.ValidationError;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Objects;

@ControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ValidationError> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception) {
        return ResponseEntity.badRequest().body(new ValidationError(
                "2021-08-09T18:00:00",
                400,
                "Bad Request",
                Objects.requireNonNull(exception.getBindingResult().getFieldError()).getDefaultMessage(),
                "/medico/save"));
    }


    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ValidationError> handleHttpMessageNotReadableException(HttpMessageNotReadableException exception) {
        return ResponseEntity.badRequest().body(new ValidationError(
                "2021-08-09T18:00:00",
                400,
                "Bad Request",
                "La especialidad no es válida",
                "/medico/save"));
    }

}
