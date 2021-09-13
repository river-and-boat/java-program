package com.rb.datatransferformatdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class DataTransferFormatDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DataTransferFormatDemoApplication.class, args);
    }

}
