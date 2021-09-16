package demo.blocking_queue;

import demo.rotation_task_demo.WhileQueue;

public class BlockingQueueTest {
    public static void main(String[] args) {
        BlockingQueue<String> queue = new BlockingQueue<>(5);

        new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                try {
                    queue.put("消息: " + i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                try {
                    queue.take();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
