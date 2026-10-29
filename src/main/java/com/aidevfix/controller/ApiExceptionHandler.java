package com.aidevfix.controller;

import com.aidevfix.service.AiProviderException;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApiExceptionHandler {
    @ExceptionHandler(AiProviderException.class)
    public ResponseEntity<Map<String, Object>> handleProvider(AiProviderException ex) {
        return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(Map.of("success", false, "message", ex.getMessage()));
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, Object>> handleValidation(MethodArgumentNotValidException ex) {
        String message = ex.getBindingResult().getFieldErrors().stream().findFirst()
                .map(e -> e.getDefaultMessage()).orElse("Please check the submitted fields.");
        return ResponseEntity.badRequest().body(Map.of("success", false, "message", message));
    }
}
