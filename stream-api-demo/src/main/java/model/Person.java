package model;

public class Person {
    private String name;
    private Integer age;
    private String address;
    private Double salary;

    public Person(final String name, final Integer age, final String address, final Double salary) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(final Integer age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(final String address) {
        this.address = address;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(final Double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                ", salary=" + salary +
                '}';
    }
}
