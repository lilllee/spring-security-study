package com.example.springsecuritystudy.repository;

import com.example.springsecuritystudy.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // select * from user where username = 1?
    User findByUsername(String username);

    // select * from user where email = ?
    User findByEmail(String email);
}
