package com.example.cloudservice.service;

import com.example.cloudservice.model.entity.FileEntity;
import com.example.cloudservice.repository.FileRepository;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.transaction.annotation.Transactional;
import org.testcontainers.junit.jupiter.Testcontainers;

import static com.example.cloudservice.exceptions.MessageConstant.*;
import static com.example.cloudservice.service.PrepareInfoForTest.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Testcontainers
@Transactional
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
public class FileServiceTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private FileRepository fileRepository;

    @MockBean
    private CheckTokenService checkTokenService;


    public void mockRepo() {
        getFileToUploadTest();
        fileRepository.save(getTestUserEntity());
    }

    @AfterEach
    public void cleanDBContainer() {
        fileRepository.deleteAllInBatch();
    }

    @Test
    public void uploadValidFileTest() throws Exception {
        Mockito.doNothing().when(checkTokenService).testToken(TOKEN);
        mockMvc.perform(MockMvcRequestBuilders.multipart(FILE)
                .file(getFileToUploadTest())
                .characterEncoding("UTF-8")
                .header("auth-token", TOKEN))
                .andExpect(MockMvcResultMatchers.status().isOk());
        FileEntity file = fileRepository.findByFilename(FILENAME);
        assertNotNull(file);
    }

    @Test
    public void uploadNonValidFileTest() throws Exception {
        Mockito.doNothing().when(checkTokenService).testToken(TOKEN);
        getPerform();
        getPerform()
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andExpect(MockMvcResultMatchers.content().contentTypeCompatibleWith(MediaType.TEXT_PLAIN))
                .andExpect(MockMvcResultMatchers.content().string(ERROR_UPLOAD_NOT_UNIQ_FILE));
    }

    private ResultActions getPerform() throws Exception {
        return mockMvc.perform(MockMvcRequestBuilders.multipart(FILE)
                .file(getFileToUploadTest())
                .characterEncoding("UTF-8")
                .header("auth-token", TOKEN));
    }

    @Test
    public void deleteFileTest() throws Exception {
        mockRepo();
        Mockito.doNothing().when(checkTokenService).testToken(TOKEN);
        mockMvc.perform(MockMvcRequestBuilders.delete(FILE)
                .param(getFileToUploadTest().getName(), FILENAME)
                .characterEncoding("UTF-8")
                .header("auth-token", TOKEN))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void getFileTest() throws Exception {
        mockRepo();
        Mockito.doNothing().when(checkTokenService).testToken(TOKEN);
        mockMvc.perform(MockMvcRequestBuilders.get(FILE)
                .param(getFileToUploadTest().getName(), FILENAME)
                .characterEncoding("UTF-8")
                .header("auth-token", TOKEN)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentTypeCompatibleWith(MediaType.TEXT_PLAIN));
    }
}