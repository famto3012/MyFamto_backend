package com.example.famto.repository;

import com.example.famto.entity.Login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface LoginRepository extends JpaRepository<Login, Long> {

    boolean existsByName(String name);
}
