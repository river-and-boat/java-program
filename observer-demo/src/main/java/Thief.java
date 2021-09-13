public class Thief {
    private ThiefListener listener;

    public void registerListener(ThiefListener listener) {
        this.listener = listener;
    }

    public void steal() {
        System.out.println("to steal money...");
        if (listener != null) {
            Event event = new Event(this);
            listener.shot(event);
        }
    }
}
