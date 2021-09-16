package demo.wait_notify_queue;

import java.util.LinkedList;
import java.util.concurrent.ArrayBlockingQueue;

public class WaitNotifyQueue<T> {
    private final LinkedList<T> queue = new LinkedList<>();

    public synchronized void put(T resource) throws InterruptedException {
        while (queue.size() >= 1) {
            System.out.println("生产者：队列已满，无法插入...");
            this.wait();
        }
        System.out.println("生产者：插入" + resource + "!!!");
        queue.addFirst(resource);
        this.notifyAll();
    }

    public synchronized void take() throws InterruptedException {
        while (queue.size() <= 0) {
            System.out.println("消费者：队列为空，无法取出...");
            this.wait();
        }
        System.out.println("消费者：取出消息");
        queue.removeLast();
        this.notifyAll();
    }
}
