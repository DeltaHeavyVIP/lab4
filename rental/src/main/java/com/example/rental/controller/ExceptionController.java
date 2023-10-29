package com.example.rental.controller;

import com.example.exception.CarAlreadyUsedException;
import com.example.exception.InvalidDataException;
import com.example.exception.ResourceNotFoundException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.gson.Gson;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@ControllerAdvice
public class ExceptionController {
    private final Gson gson = new Gson();

    @ExceptionHandler({ResourceNotFoundException.class})
    public ResponseEntity<String> handleResourceNotFoundException(ResourceNotFoundException resourceNotFoundException) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("message", resourceNotFoundException.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(gson.toJson(hashMap));
    }

    @ExceptionHandler(CarAlreadyUsedException.class)
    public ResponseEntity<String> handleCarAlreadyUsedException(CarAlreadyUsedException carAlreadyUsedException) throws JsonProcessingException {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("message", carAlreadyUsedException.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(gson.toJson(hashMap));
    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> handleValidationException(MethodArgumentNotValidException e) throws JsonProcessingException {
        InvalidDataException invalidDataException = new InvalidDataException(e.getMessage(),
                prepareValidationErrors(e.getFieldErrors()));
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(gson.toJson(invalidDataException));
    }

    private Map<String, String> prepareValidationErrors(List<FieldError> errors) {
        return errors.stream().collect(Collectors.toMap(
                FieldError::getField,
                e -> "Field has wrong value " + e.getRejectedValue() + "; " + e.getDefaultMessage()
        ));
    }

}
