package hello.file_practice.service;

import hello.file_practice.domain.UploadFile;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileStore {
    @Value("${file.dir}")
    private String filePath;

    public String getFullPath(String fileName) {
        return filePath + fileName;
    }

    public UploadFile storeFile(MultipartFile file) throws IOException {
        if (file.isEmpty()) {
            return null;
        }
        String originalFilename = file.getOriginalFilename();
        String uuid = UUID.randomUUID().toString();
        String fullPath = getFullPath(originalFilename);
        String resultFileName = getString(originalFilename, uuid);
        file.transferTo(new File(filePath + resultFileName));
        return new UploadFile(originalFilename, resultFileName);
    }

    public List<UploadFile> storeFiles(List<MultipartFile> files) throws IOException {
        List<UploadFile> uploadFiles = new ArrayList<>();
        for (MultipartFile file : files) {
            if (!file.isEmpty()) {
                uploadFiles.add(storeFile(file));
            }
        }
        return uploadFiles;
    }

    private static String getString(String originalFilename, String uuid) {
        int position = originalFilename.lastIndexOf(".");
        String substring = originalFilename.substring(position + 1);
        return uuid + "." + substring;
    }
}
