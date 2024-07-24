package com.setect.spring_mvc.models;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

public class FileUploadUtil {
    public static void saveFile(String uploadDir, String fileName, MultipartFile file) throws IOException {
        Path uploadPath = Paths.get("src/main/resources/static/" + uploadDir);
        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }

        try {

            Files.copy(file.getInputStream(), uploadPath.resolve(fileName));
        } catch (IOException e) {
            throw new IOException("Could not save file: " + fileName, e);
        }
    }

    public static void removePhoto(String fileName) throws IOException {
        Path uploadPath = Paths.get("src/main/resources/static/photos/" + fileName);
        try {
            if (Files.exists(uploadPath)) {
                Files.delete(uploadPath);
            }
        } catch (IOException e) {
            throw new IOException("Could not save file: " + fileName, e);
        }
    }
}
