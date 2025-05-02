package com.example.workshop_BE.controller;

import com.example.workshop_BE.model.Task;
import com.example.workshop_BE.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

@RestController
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping("/addTask")
    public ResponseEntity<HashMap<String, Object>> addTask(@RequestBody Task task)
    {
        HashMap<String, Object> response = new HashMap<>();
        taskService.addTask(task.getTaskName(), task.getDescription());
        response.put("status", HttpStatus.OK);
        response.put("message", "Task added successfully");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/getAllTasks")
    public ResponseEntity<List<Task>> getAllTasks() {
        List<Task> tasks = taskService.getAllTasks();  // This should fetch tasks from MongoDB
        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }

    @GetMapping("/getTasksById")
    public ResponseEntity<Task> getTaskById(@RequestParam String id) {
        Task task = taskService.fetchTaskById(id);
        return new ResponseEntity<>(task, HttpStatus.OK);
    }

    @PutMapping("/markTaskAsCompleted/{id}")
    public ResponseEntity<String> markTaskCompleted(@PathVariable String id) {
        try {
            taskService.markTaskCompleted(id);
            return ResponseEntity.ok("Task marked as completed successfully");
        } catch (Exception e) {
            return ResponseEntity.status(400).body("Error marking task as completed");
        }
    }




}
