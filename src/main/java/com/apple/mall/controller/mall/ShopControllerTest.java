package com.apple.mall.controller.mall;

import org.springframework.util.ResourceUtils;

import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

class ShopControllerTest {



    @org.junit.jupiter.api.Test
    void registerVerify() throws FileNotFoundException {
        Path path = Paths.get("src\\main\\resources\\static\\mall\\image\\shops\\");
        String image=path.toString();
        image=image.replace("\\","/");
        image=image.substring(4);
        System.out.println(image);

    }
}