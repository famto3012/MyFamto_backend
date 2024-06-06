package com.example.famto.repository;

import com.example.famto.entity.TaskModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository

public interface TaskRepo extends JpaRepository<TaskModel, Integer> {


}