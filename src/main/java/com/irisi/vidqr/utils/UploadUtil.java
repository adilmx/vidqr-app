package com.irisi.vidqr.utils;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.Map;

@Component
@Slf4j
@RequiredArgsConstructor
public class UploadUtil {

    private final Cloudinary cloudinary;

    public String upload(String file) {
        Map uploadResult = null;
        try {
            File savedFile = getFileFromBase64(file);
            if (savedFile == null) return "";
            uploadResult = cloudinary.uploader().upload(savedFile, ObjectUtils.asMap("resource_type", "auto"));
            return uploadResult.get("url").toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

    private File getFileFromBase64(String base64File) throws IOException {
        byte[] decodedImg = Base64.getDecoder()
                .decode(base64File.getBytes(StandardCharsets.UTF_8));
        ClassPathResource res = new ClassPathResource("data");
        Path destinationFile = Paths.get(res.getPath());
        try {
            Files.write(destinationFile, decodedImg);
            return ResourceUtils.getFile(res.getPath());
        } catch (IOException e) {
            log.error("Error {}", e.getMessage());
        }
        return null;
    }
}
