package demo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.LockSupport;

public class PartTest {
    public static void main(String[] args) throws InterruptedException {
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(() -> {
                System.out.println("我是" + Thread.currentThread().getName() + ", 我开始工作了~");
                LockSupport.park(PartTest.class);
                System.out.println("我是" + Thread.currentThread().getName() + ", 我又活过来了~");
            });
            thread.start();
            threads.add(thread);
        }

        Thread.sleep(3 * 1000L);
        System.out.println("=============所有线程都阻塞了，三秒恢复=============");

        for (Thread thread :
                threads) {
            LockSupport.unpark(thread);
        }
        Thread.sleep(3 * 1000L);
    }
}
