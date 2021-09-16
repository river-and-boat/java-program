package com.rb.myasyncdemo;

import com.rb.myasyncdemo.annotation.EnableMyAsync;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class MyAsyncDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyAsyncDemoApplication.class, args);
    }

}
