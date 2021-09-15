package com.rb.bootencoderdemo.controller.request;

public class UserRequest {
    public String name;
    public String password;
    public Integer age;

    public UserRequest() {
    }

    public UserRequest(final String name, final String password, final Integer age) {
        this.name = name;
        this.password = password;
        this.age = age;
    }
}
