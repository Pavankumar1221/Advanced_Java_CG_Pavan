package com.cg.services;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import java.net.MalformedURLException;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.cg.config.FileStorageProperties;

@Service
public class FileStorageService {

    // location where files will be stored
    private final Path fileStorageLocation;

    public FileStorageService(FileStorageProperties props) {

        // convert upload directory to absolute path
        this.fileStorageLocation = Paths
                .get(props.getUploadDir())
                .toAbsolutePath()
                .normalize();

        System.out.println("Upload Path: " + this.fileStorageLocation);

        try {
            // create directory if it doesn't exist
            Files.createDirectories(this.fileStorageLocation);
        } 
        catch (Exception e) {
            throw new RuntimeException("Could not create upload directory");
        }
    }


    // ================= STORE FILE =================

    public String storeFile(MultipartFile file) {

        try {

            // clean file name
            String fileName = StringUtils.cleanPath(file.getOriginalFilename());

            // security check
            if (fileName.contains("..")) {
                throw new RuntimeException("Invalid file path");
            }

            // determine target location
            Path targetLocation = this.fileStorageLocation.resolve(fileName);

            // copy file
            Files.copy(file.getInputStream(),
                    targetLocation,
                    StandardCopyOption.REPLACE_EXISTING);

            return fileName;

        } 
        catch (Exception e) {
            throw new RuntimeException("File upload failed", e);
        }
    }


    // ================= LOAD FILE =================

    public Resource loadFileAsResource(String fileName) {

        try {

            Path filePath = this.fileStorageLocation
                    .resolve(fileName)
                    .normalize();

            Resource resource = new UrlResource(filePath.toUri());

            if (resource.exists()) {
                return resource;
            }
            else {
                throw new RuntimeException("File not found");
            }

        }
        catch (MalformedURLException e) {
            throw new RuntimeException("File not found", e);
        }
    }

}