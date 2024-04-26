package com.example.cloudservice.exceptions;

public class RenameFileException extends RuntimeException {
    public RenameFileException(String message) {
        super(message);
    }
}