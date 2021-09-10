import java.time.LocalDateTime;

public class DateTimeEdit {
    public static void main(String[] args) {
        System.out.println("替换时间：");
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime modifiedDateTime = now.withDayOfMonth(1);
        System.out.println(modifiedDateTime);

        System.out.println("判断时间：");
        LocalDateTime today = LocalDateTime.now();
        LocalDateTime after = today.plusSeconds(1);
        boolean result = after.isAfter(today);
        System.out.println("result=" + result);
    }
}
