package com.example.famto.controller;

import com.example.famto.entity.TaskModel;
import com.example.famto.exception.ResourceNotFoundException;
import com.example.famto.repository.TaskRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/task")
public class TaskController {

    @Autowired
    private TaskRepo taskRepository;

    // create order
    @PostMapping
    public TaskModel createTask(@RequestBody TaskModel task) {
        return this.taskRepository.save(task);
    }

    // get all orders
    @GetMapping
    public List<TaskModel> getAllOrders() {
        return this.taskRepository.findAll();
    }

    // get order by id
    @GetMapping("/{newId}")
    public TaskModel getOrderById(@PathVariable(value = "newId") Integer newId) {
        return this.taskRepository.findById(newId).orElseThrow(() -> new ResourceNotFoundException("Order not found with newId :" + newId));
    }


}
