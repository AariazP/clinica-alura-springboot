package org.example.clinicaalura.exceptions;

import org.example.clinicaalura.dto.error.ValidationError;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.NoSuchElementException;
import java.util.Objects;

@ControllerAdvice
public class BadRequestExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ValidationError> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception) {
        String errorMessage = Objects.requireNonNull(exception.getBindingResult().getFieldError()).getDefaultMessage();
        return buildErrorResponse(errorMessage);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ValidationError> handleHttpMessageNotReadableException(HttpMessageNotReadableException exception) {
        return buildErrorResponse("La especialidad no es válida");
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ValidationError> handleDataIntegrityViolationException(DataIntegrityViolationException exception) {
        return buildErrorResponse("El email ya está registrado");
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<ValidationError> handleNoMedicoFound(NoSuchElementException exception){
        return buildErrorResponse("No se encuentra el médico");
    }

    private ResponseEntity<ValidationError> buildErrorResponse(String errorMessage) {
        ValidationError error = new ValidationError(
                "2021-08-09T18:00:00",
                400,
                "Bad Request",
                errorMessage,
                "/medico/save"
        );
        return ResponseEntity.badRequest().body(error);
    }

}
