package com.example.famto.repository;

import com.example.famto.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);

    User findById(User id);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);
}