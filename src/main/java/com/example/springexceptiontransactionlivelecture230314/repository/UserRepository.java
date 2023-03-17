package com.example.springexceptiontransactionlivelecture230314.repository;

import com.example.springexceptiontransactionlivelecture230314.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
