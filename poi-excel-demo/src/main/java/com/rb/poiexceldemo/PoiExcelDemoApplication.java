package com.rb.poiexceldemo;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PoiExcelDemoApplication {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        SpringApplication.run(PoiExcelDemoApplication.class, args);

        new Thread(
                () -> System.out.println(Thread.currentThread().getName() + "======== is running")
        ).start();

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<String> submit = executorService.submit(() -> {
            System.out.println(Thread.currentThread().getName() + "========>正在执行");
            Thread.sleep(3 * 1000L);
            return "success";
        });
        String result = submit.get();
        System.out.println("result==========>" + result);
        executorService.shutdown();
    }
}
