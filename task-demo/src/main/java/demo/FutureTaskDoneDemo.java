package demo;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureTaskDoneDemo {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<String> futureTask = executorService.submit(() -> {
            System.out.println(Thread.currentThread().getName() + "===========>正在执行");
            Thread.sleep(3 * 1000L);
            return "success";
        });

        Thread.sleep(1000L);

        if (futureTask.isDone()) {
            System.out.println("异步线程结束，获取结果: " + futureTask.get());
        } else {
            System.out.println("异步线程尚未结束，稍后再试");
        }

        Thread.sleep(1000L);
        Thread.sleep(1000L);

        if (futureTask.isDone()) {
            System.out.println("异步线程结束，获取结果: " + futureTask.get());
        } else {
            System.out.println("异步线程尚未结束，稍后再试");
        }
    }
}
