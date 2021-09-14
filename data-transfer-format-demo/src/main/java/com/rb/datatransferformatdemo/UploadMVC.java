package com.rb.datatransferformatdemo;

import com.rb.datatransferformatdemo.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class UploadMVC {
    private final User user;

    public UploadMVC(final User user) {
        this.user = user;
    }

    @PostMapping("springUpload")
    public void resolveUserInfo(String name, Integer age, MultipartFile file) {
        System.out.println("POST请求: " + name + ", age: " + age + ", file: " + file);
    }

    @GetMapping("/user")
    public User getUserInfo() {
        return user;
    }
}
