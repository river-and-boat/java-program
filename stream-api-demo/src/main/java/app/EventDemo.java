package app;

import model.EventRegistry;
import model.MyEvent;

public class EventDemo {
    public static void main(String[] args) {
        MyEvent event1 = () -> System.out.println("Hello World 1");
        MyEvent event2 = () -> System.out.println("Hello World 2");

        EventRegistry.register(event1);
        EventRegistry.register(event2);
        EventRegistry.run();
    }
}
