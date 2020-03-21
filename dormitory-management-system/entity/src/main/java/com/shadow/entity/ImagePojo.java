package com.shadow.entity;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class ImagePojo {

    private MultipartFile image;

    private String oldimage;

    private String imagetype;
}
