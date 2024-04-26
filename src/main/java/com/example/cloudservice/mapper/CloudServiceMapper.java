package com.example.cloudservice.mapper;

import com.example.cloudservice.dto.FileResponse;
import com.example.cloudservice.model.entity.FileEntity;

import java.util.List;

public interface CloudServiceMapper {
    List<FileResponse> fileEntityToFileResponse(List<FileEntity> list, Integer limit);
}