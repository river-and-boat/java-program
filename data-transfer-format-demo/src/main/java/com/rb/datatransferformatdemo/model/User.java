package com.rb.datatransferformatdemo.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;

public class User {
    public String username;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public LocalDateTime date = LocalDateTime.now();

    public User(final String username) {
        this.username = username;
    }
}
