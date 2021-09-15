package com.rb.bootencoderdemo.controller.response;

public class UserResponse {
    public String name;
    public String password;
    public Integer age;

    public UserResponse() {
    }

    public UserResponse(final String name, final String password, final Integer age) {
        this.name = name;
        this.password = password;
        this.age = age;
    }
}
