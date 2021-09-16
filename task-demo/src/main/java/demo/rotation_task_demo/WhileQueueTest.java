package demo.rotation_task_demo;

public class WhileQueueTest {
    public static void main(String[] args) {
        WhileQueue<String> queue = new WhileQueue<>();

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
