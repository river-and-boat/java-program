import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class DateTimePlusOrMinus {
    public static void main(String[] args) {
        System.out.println("获取时间参数的年、月、日: ");
        LocalDateTime time = LocalDateTime.now();
        System.out.println("year: " + time.getYear());
        System.out.println("month: " + time.getMonth());
        System.out.println("day: " + time.getDayOfMonth());
        System.out.println("hour: " + time.getHour());
        System.out.println("minute: " + time.getMinute());
        System.out.println("second: " + time.getSecond());

        System.out.println("\n计算前一天的当前时刻");
        LocalDateTime yesterday = time.minusDays(1);
        System.out.println("yesterday: " + yesterday);

        System.out.println("\n计算一周、一个月和一年的当前时刻");
        LocalDateTime oneWeekAgo = time.minus(1, ChronoUnit.WEEKS);
        LocalDateTime oneMonthAgo = time.minus(1, ChronoUnit.MONTHS);
        LocalDateTime oneYearAgo = time.minus(1, ChronoUnit.YEARS);
        LocalDateTime tomorrow = time.plus(1, ChronoUnit.DAYS);

        System.out.println("one week ago: " + oneWeekAgo);
        System.out.println("one month ago: " + oneMonthAgo);
        System.out.println("one year ago: " + oneYearAgo);
        System.out.println("tomorrow: " + tomorrow);
    }
}
