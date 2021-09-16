package demo;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class FutureTaskTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<String> runnable = new FutureTask<>(
                () -> System.out.println(Thread.currentThread().getName() + "========>正在执行"),
                "success"
        );

        FutureTask<String> callable = new FutureTask<>(() -> {
            System.out.println(Thread.currentThread().getName() + "========>2正在执行");
            Thread.sleep(10 * 1000L);
            return "success";
        });
        new Thread(callable).start();
        new Thread(runnable).start();
        System.out.println("I am main thread: " + Thread.currentThread());
        String callableResult = callable.get();
        String runnableResult = runnable.get();
        System.out.println("runnable result ============> " + runnableResult);
        System.out.println("callable result ============> " + callableResult);
    }
}
