package model;

public class Department {
    private String name;
    private Integer code;

    public Department() {
    }

    public Department(final String name, final Integer code) {
        this.name = name;
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(final Integer code) {
        this.code = code;
    }
}
