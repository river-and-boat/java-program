import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class NewDateApiTest {
    public static void main(String[] args) {
        LocalDate newDate = LocalDate.now();
        LocalTime newTime = LocalTime.now();
        LocalDateTime newDateTime = LocalDateTime.now();

        System.out.println("new date: " + newDate);
        System.out.println("new time: " + newTime);
        System.out.println("new date time: " + newDateTime);

        // 组合
        LocalDateTime combineDateTime = LocalDateTime.of(newDate, newTime);
        System.out.println("combine date time: " + combineDateTime);

        // 创建指定时间
        LocalDate customDate = LocalDate.of(2020, 11, 5);
        LocalTime customTime = LocalTime.of(16,30,10);
        LocalDateTime customDateTime = LocalDateTime.of(2020,11,5,16,30,0);
        System.out.println("custom date: " + customDate);
        System.out.println("custom time: " + customTime);
        System.out.println("custom date time: " + customDateTime);
    }
}
