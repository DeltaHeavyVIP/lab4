package com.example.exception;

public class CarAlreadyUsedException extends RuntimeException {
    public CarAlreadyUsedException(String message) {
        super(message);
    }
}
