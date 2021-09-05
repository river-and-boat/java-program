package app;

import model.Employee;
import my_enum.WeekDay;

public class EnumDemo {
    public static void main(String[] args) {
        Employee employee = new Employee();
        employee.setRestDay(WeekDay.MONDAY);
        System.out.println(employee.getRestDay());
    }
}
