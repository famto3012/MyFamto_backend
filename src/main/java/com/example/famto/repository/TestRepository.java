package com.example.famto.repository;

import com.example.famto.entity.Test;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository

public interface TestRepository extends JpaRepository<Test, Long> {


}