package com.example.cars.controller;

import com.example.exception.CarAlreadyUsedException;
import com.example.exception.InvalidDataException;
import com.example.exception.ResourceNotFoundException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.gson.Gson;
import jakarta.validation.ConstraintViolationException;
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

    @ExceptionHandler({ConstraintViolationException.class})
    public ResponseEntity<String> handleResourceNotFoundException(ConstraintViolationException constraintViolationException) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("message", constraintViolationException.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(gson.toJson(hashMap));
    }

}
