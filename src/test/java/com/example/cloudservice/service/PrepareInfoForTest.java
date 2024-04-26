package com.example.cloudservice.service;

import com.example.cloudservice.model.entity.FileEntity;
import org.springframework.mock.web.MockMultipartFile;

public class PrepareInfoForTest {

    public final static String TOKEN = "afe1716dc4be4ecabe2926decea2cffe";
    public final static String TEST = "test";
    public final static String NON_VALID_TEST = "nonValidTest";
    public final static String FILENAME = "test.txt";

    public static MockMultipartFile getFileToUploadTest() {
        return new MockMultipartFile("filename",
                FILENAME, "text/plain", "some csv".getBytes());
    }

    public static FileEntity getTestUserEntity() {
        FileEntity file = new FileEntity(FILENAME, 2, "text/plain", null);
        file.setId(1L);
        return file;
    }
}