package model;

import java.util.ArrayList;
import java.util.List;

public class EventRegistry {
    private static final List<MyEvent> events = new ArrayList<>();

    public static void register(MyEvent event) {
        events.add(event);
    }

    public static void run() {
        events.forEach(MyEvent::click);
    }
}
