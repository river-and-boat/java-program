import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class ZoneDemo {
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        System.out.println("LocalDateTime: " + now);

        ZonedDateTime shanghai = now.atZone(ZoneId.of("Asia/Shanghai"));
        System.out.println("上海时间: " + shanghai);

        ZonedDateTime tokyoHot = shanghai.withZoneSameInstant(ZoneId.of("Asia/Tokyo"));
        System.out.println("东京时间: " + tokyoHot);

        ZoneId zoneId = ZoneId.of("Asia/Tokyo");
        ZonedDateTime tokyoTime = now.atZone(zoneId);
        System.out.println("tokyoTime: " + tokyoTime);
    }
}
