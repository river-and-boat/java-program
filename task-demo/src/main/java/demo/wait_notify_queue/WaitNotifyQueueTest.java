package demo.wait_notify_queue;

public class WaitNotifyQueueTest {
    public static void main(String[] args) {
        WaitNotifyQueue<String> queue = new WaitNotifyQueue<>();

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
