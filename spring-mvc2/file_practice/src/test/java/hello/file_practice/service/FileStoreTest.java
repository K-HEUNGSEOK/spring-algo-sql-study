package hello.file_practice.service;

import static org.junit.jupiter.api.Assertions.*;

import hello.file_practice.domain.UploadFile;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;

@SpringBootTest
class FileStoreTest {
    @Autowired
    FileStore fileStore = new FileStore();

    @Test
    void getFullPath() {
        String fullPath = fileStore.getFullPath("hello");
        Assertions.assertThat(fullPath).isEqualTo("C:/Users/82102/Desktop/file-test/hello");
        System.out.println(fullPath);
    }

    @Test
    void storeFileSuccess() throws IOException {
        MockMultipartFile file = new MockMultipartFile("file", "test.png", "image/png", "file content".getBytes(
                StandardCharsets.UTF_8));
        UploadFile uploadFile = fileStore.storeFile(file);
        Assertions.assertThat(uploadFile.getUploadFileName()).isEqualTo("test.png");
        System.out.println("storeFileName = " + uploadFile.getStoreFileName());
    }

    @Test
    void storeFileFail() throws IOException {
        MockMultipartFile file = new MockMultipartFile("file", "test.png", "text/plain", new byte[0]);
        UploadFile uploadFile = fileStore.storeFile(file);
        Assertions.assertThat(uploadFile).isNull();
    }
}