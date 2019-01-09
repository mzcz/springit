package com.marcin.springit.repository;

import com.marcin.springit.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepopsitory extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);
}
