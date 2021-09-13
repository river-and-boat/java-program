package com.rb.datatransferformatdemo;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class UploadMVC {
    @PostMapping("springUpload")
    public void resolveUserInfo(String name, Integer age, MultipartFile file) {
        System.out.println("POST请求: " + name + ", age: " + age + ", file: " + file);
    }
}
