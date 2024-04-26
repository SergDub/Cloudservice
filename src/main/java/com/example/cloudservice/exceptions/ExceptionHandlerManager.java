package com.example.cloudservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandlerManager {

    @ExceptionHandler(LoginException.class)
    public ResponseEntity<?> handlerException(LoginException exception) {
        return new ResponseEntity(exception.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InvalidTokenException.class)
    public ResponseEntity<?> handlerException(InvalidTokenException exception) {
        return new ResponseEntity(exception.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(FileUploadException.class)
    public ResponseEntity<?> handlerException(FileUploadException exception) {
        return new ResponseEntity(exception.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(DeleteFileException.class)
    public ResponseEntity<?> handlerException(DeleteFileException exception) {
        return new ResponseEntity(exception.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(DownloadFileException.class)
    public ResponseEntity<?> handlerException(DownloadFileException exception) {
        return new ResponseEntity(exception.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(RenameFileException.class)
    public ResponseEntity<?> handlerException(RenameFileException exception) {
        return new ResponseEntity(exception.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(GettingFileListException.class)
    public ResponseEntity<?> handlerException(GettingFileListException exception) {
        return new ResponseEntity(exception.getMessage(), HttpStatus.BAD_REQUEST);
    }
}