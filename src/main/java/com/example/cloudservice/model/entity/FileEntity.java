package com.example.cloudservice.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "file_table")
public class FileEntity implements Serializable {

    @Id
    @SequenceGenerator(name = "file_tableSequence", sequenceName = "file_sequence", allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "file_tableSequence")
    @Column(nullable = false)
    private Long id;

    @Column(name = "file_name")
    private String filename;

    @Column(name = "size")
    private Long size;

    @Column(name = "type")
    private String type;

    @Column(name = "body")
    private byte[] body;

    public FileEntity(String filename, long size, String type, byte[] body) {
        this.filename = filename;
        this.size = size;
        this.type = type;
        this.body = body;
    }
}