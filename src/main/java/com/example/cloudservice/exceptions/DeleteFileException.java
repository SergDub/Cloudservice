package com.example.cloudservice.exceptions;

public class DeleteFileException extends RuntimeException {
    public DeleteFileException(String message) {
        super(message);
    }
}