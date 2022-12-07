package com.codegym.spring_security.repository;

import com.codegym.spring_security.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User,Integer> {
    User findByUsername(String username);
}
