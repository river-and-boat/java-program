package model;

import my_enum.WeekDay;

public class Employee {
    private WeekDay restDay;

    public void setRestDay(final WeekDay restDay) {
        this.restDay = restDay;
    }

    public String getRestDay() {
        return restDay.getDesc();
    }
}
