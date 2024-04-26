package com.example.cloudservice.mapper;

import com.example.cloudservice.dto.FileResponse;
import com.example.cloudservice.model.entity.FileEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CloudServiceMapperIpml implements CloudServiceMapper {

    @Override
    public List<FileResponse> fileEntityToFileResponse(List<FileEntity> list, Integer limit) {
        return list.stream().map(f -> new FileResponse(f.getFilename(), f.getSize()))
                .limit(limit)
                .collect(Collectors.toList());
    }
}