package com.rb.bootencoderdemo.service;

import com.rb.bootencoderdemo.configuration.RsaKeyConfig;
import com.rb.bootencoderdemo.controller.response.UserResponse;
import com.rb.bootencoderdemo.model.User;
import com.rb.bootencoderdemo.repository.UserRepository;
import com.rb.bootencoderdemo.utils.RsaUtils;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final RsaKeyConfig rsaKeyConfig;

    public UserService(UserRepository userRepository, final RsaKeyConfig rsaKeyConfig) {
        this.userRepository = userRepository;
        this.rsaKeyConfig = rsaKeyConfig;
    }

    public List<UserResponse> getUsers() {
        List<UserResponse> responses = new ArrayList<>();
        List<User> users = userRepository.findAll();
        users.forEach(user -> {
            try {
                String decodedName = new String(
                        RsaUtils.privateDecrypt(user.getName(), RsaUtils.getPrivateKey(rsaKeyConfig.getPriKeyPath()))
                );
                String decodedPassword = new String(
                        RsaUtils.privateDecrypt(user.getPassword(), RsaUtils.getPrivateKey(rsaKeyConfig.getPriKeyPath()))
                );
                responses.add(new UserResponse(decodedName, decodedPassword, user.getAge()));
            } catch (Exception e) {
                System.out.println("error occurred: " + e.getMessage());
            }
        });
        return responses;
    }

    public void saveUser(String name, String password, Integer age) throws Exception {
        String encodedName = RsaUtils.publicEncrypt(
                name.getBytes(), RsaUtils.getPublicKey(rsaKeyConfig.getPubKeyPath())
        );
        String encodedPassword = RsaUtils.publicEncrypt(
                password.getBytes(), RsaUtils.getPublicKey(rsaKeyConfig.getPubKeyPath())
        );
        userRepository.save(new User(encodedName, encodedPassword, age));
    }
}
