package my_enum;

public class WeekDay {
    private final Integer code;
    private final String desc;

    private WeekDay(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public static final WeekDay MONDAY = new WeekDay(1, "Monday");
    public static final WeekDay TUESDAY = new WeekDay(2, "Tuesday");
    public static final WeekDay WEDNESDAY = new WeekDay(3, "Wednesday");
    public static final WeekDay THURSDAY = new WeekDay(4, "Thursday");
    public static final WeekDay FRIDAY = new WeekDay(5, "Friday");
    public static final WeekDay SATURDAY = new WeekDay(6, "Saturday");
    public static final WeekDay SUNDAY = new WeekDay(7, "Sunday");

    public String getDesc() {
        return desc;
    }

    public Integer getCode() {
        return code;
    }
}
