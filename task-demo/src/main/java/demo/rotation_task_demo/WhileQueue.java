package demo.rotation_task_demo;

import java.util.LinkedList;
import java.util.concurrent.TimeUnit;

public class WhileQueue<T> {
    private final LinkedList<T> queue = new LinkedList<>();

    public void put(T resource) throws InterruptedException {
        while (queue.size() >= 1) {
            System.out.println("生产者：队列已满，无法插入...");
            TimeUnit.MILLISECONDS.sleep(1000L);
        }
        System.out.println("生产者：插入" + resource + "!!!");
        queue.addFirst(resource);
    }

    public void take() throws InterruptedException {
        while (queue.size() <= 0) {
            System.out.println("消费者：队列为空，无法取出...");
            TimeUnit.MILLISECONDS.sleep(1000L);
        }
        System.out.println("消费者：取出消息!!!");
        queue.removeLast();
        TimeUnit.MILLISECONDS.sleep(5000);
    }
}
