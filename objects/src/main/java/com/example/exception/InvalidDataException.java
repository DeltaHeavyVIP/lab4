package com.example.exception;

import java.io.Serializable;
import java.util.Map;

public class InvalidDataException implements Serializable {
    private final String message;
    private final Map<String, String> errors;

    public InvalidDataException(String message, Map<String, String> errors) {
        this.message = message;
        this.errors = errors;
    }
}
