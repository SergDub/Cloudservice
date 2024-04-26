package com.example.cloudservice.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.cloudservice.model.entity.FileEntity;
import org.springframework.data.jpa.repository.Query;

@Repository
public interface FileRepository extends JpaRepository<FileEntity, Long> {

    @Query(value = "select f from FileEntity f where f.filename = :filename")
    FileEntity findByFilename(String filename);
}