public class ObserverTest {
    public static void main(String[] args) {
        Thief thief = new Thief();
        ThiefListener thiefListener = event -> System.out.println(event.getThief());
        thief.registerListener(thiefListener);
        thief.steal();
    }
}
