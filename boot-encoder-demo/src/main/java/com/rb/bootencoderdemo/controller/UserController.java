package com.rb.bootencoderdemo.controller;

import com.rb.bootencoderdemo.controller.request.UserRequest;
import com.rb.bootencoderdemo.controller.response.UserResponse;
import com.rb.bootencoderdemo.service.UserService;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    private final UserService userService;

    public UserController(final UserService userService) {
        this.userService = userService;
    }

    @PostMapping("users")
    public void saveUser(@RequestBody UserRequest userRequest) throws Exception {
        userService.saveUser(userRequest.name, userRequest.password, userRequest.age);
    }

    @GetMapping("users")
    public List<UserResponse> getUsers() throws Exception {
        return userService.getUsers();
    }
}
