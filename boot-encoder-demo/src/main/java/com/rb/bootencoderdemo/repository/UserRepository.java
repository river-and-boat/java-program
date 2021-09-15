package com.rb.bootencoderdemo.repository;

import com.rb.bootencoderdemo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
