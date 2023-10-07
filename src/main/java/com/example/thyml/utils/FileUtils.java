package com.example.thyml.utils;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import com.example.thyml.entity.User;
import org.springframework.core.io.ClassPathResource;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUtils {

    public void saveFile(MultipartFile file, String fileResourcePath) throws Exception {
        fileResourcePath = "./src/main/resources/static" + fileResourcePath;
        Path savedFilePath = Paths.get(fileResourcePath);
        if (!Files.exists(savedFilePath)) {
            String dirs = fileResourcePath.substring(0, fileResourcePath.lastIndexOf("/"));
            Files.createDirectories(Paths.get(dirs));
            Files.createFile(savedFilePath);
        }
        Files.write(savedFilePath, file.getBytes());
    }

    public String getUserPhotoFilePath(@NonNull User user) {
        String multipartFileName = user.getPhoto().getOriginalFilename();
        String extension = multipartFileName.substring(multipartFileName.lastIndexOf("."));
        return "/img/user_photo_" + user.getUsername() + extension;
    }

}
