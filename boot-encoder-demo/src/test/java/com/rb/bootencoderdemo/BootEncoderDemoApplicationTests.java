package com.rb.bootencoderdemo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BootEncoderDemoApplicationTests {

    @Test
    void contextLoads() {
        String secret = "oQotghpJzWFtXhpZk305YT6aKx4cF5n2khMJGtFDhr8=";
        byte[] bytes = secret.getBytes();
        System.out.println(bytes.length);
    }

}
