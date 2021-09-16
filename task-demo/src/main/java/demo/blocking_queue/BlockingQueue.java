package demo.blocking_queue;

import java.util.LinkedList;
import java.util.concurrent.Executor;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class BlockingQueue<T> {
    private final LinkedList<T> queue = new LinkedList<>();

    private int MAX_SIZE = 1;
    private int remainCount = 0;

    private final ReentrantLock lock = new ReentrantLock();
    private final Condition producerCondition = lock.newCondition();
    private final Condition consumerCondition = lock.newCondition();

    public BlockingQueue(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("size最小为1");
        }
        this.MAX_SIZE = capacity;
    }

    public void put(T resource) throws InterruptedException {
        lock.lock();
        try {
            while (queue.size() >= MAX_SIZE) {
                System.out.println("队列元素已达上限");
                producerCondition.await();
            }
            queue.addFirst(resource);
            remainCount++;
            System.out.println("生产者：插入" + resource + "!!!");
            consumerCondition.signal();
        } finally {
            lock.unlock();
        }
    }

    public void take() throws InterruptedException {
        lock.lock();
        try {
            while (queue.size() <= 0) {
                System.out.println("消费者：队列为空，无法取出...");
                consumerCondition.await();
            }
            System.out.println("消费者：取出" + queue.getLast() + "!!!");
            queue.removeLast();
            remainCount--;
            producerCondition.signal();
        } finally {
            lock.unlock();
        }
    }
}
