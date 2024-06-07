package org.example.clinicaalura.dto.error;

public record ValidationError(
        String timestamp,
        Integer status,
        String error,
        String message,
        String path
) {
}
