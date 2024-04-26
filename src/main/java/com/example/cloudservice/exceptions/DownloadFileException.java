package com.example.cloudservice.exceptions;

public class DownloadFileException extends RuntimeException {
    public DownloadFileException(String message) {
        super(message);
    }
}