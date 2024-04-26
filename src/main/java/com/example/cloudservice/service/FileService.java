package com.example.cloudservice.service;

import com.example.cloudservice.dto.NewFilenameRequest;
import com.example.cloudservice.model.entity.FileEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface FileService {

    List<FileEntity> getAllFiles();

    String uploadFile(MultipartFile file);

    String deleteFile(String filename);

    FileEntity getFile(String filename);

    String renameFile(String filename, NewFilenameRequest newFilename);
}