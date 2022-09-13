package com.project.bedroommanagement.helper;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Component
public class FileUploadHelper {
    public final String UPLOAD_DIRECTORY = new ClassPathResource("static/image").getFile().getAbsolutePath();
    public FileUploadHelper()throws IOException{

    }

    public boolean uploadFile(MultipartFile multipartFile){
        boolean response=false;
        try{
            Files.copy(multipartFile.getInputStream(), Paths.get(UPLOAD_DIRECTORY+File.separator+multipartFile.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
            response=true;
        }catch (Exception e){

        }
        return response;
    }
}
