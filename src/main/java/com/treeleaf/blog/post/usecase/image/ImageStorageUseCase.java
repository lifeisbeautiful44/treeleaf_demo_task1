package com.treeleaf.blog.post.usecase.image;


import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

@Service
public class ImageStorageUseCase {

    public String uploadImage(String path, MultipartFile file)  {
        String name = UUID.randomUUID().toString() + "_" + file.getOriginalFilename();

        System.out.println(name);
        String filePath = path + File.separator + name;

        System.out.println(filePath);


        //creating folder if donot exist;
        File dir = new File(path);
        if(!dir.exists())
        {
            dir.mkdir();
        }

        //copying file

        try {
            Files.copy(file.getInputStream(), Paths.get(filePath));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return name;

    }

}
