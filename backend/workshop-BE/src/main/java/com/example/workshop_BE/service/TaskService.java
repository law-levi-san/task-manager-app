package com.example.workshop_BE.service;

import com.example.workshop_BE.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TaskService {

    @Autowired
    private MongoTemplate mongoTemplate;

    public void addTask(String taskName, String description){
       Task task = new Task(taskName, description);
        mongoTemplate.save(task);
    }

    public List<Task> getAllTasks(){
       return mongoTemplate.findAll(Task.class);
    }

    public Task fetchTaskById(String id){
        return mongoTemplate.findById(id, Task.class);
    }

    public void markTaskCompleted(String id){
        Task task = mongoTemplate.findById(id, Task.class);
        task.setCompleted(true);
        mongoTemplate.save(task); // Save the updated task back to the database
    }

}
