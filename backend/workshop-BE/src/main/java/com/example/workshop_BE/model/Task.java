package com.example.workshop_BE.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.UUID;

@Data
@Document(collection = "tasks")
public class Task {

    @Id
    private String id;
    private String taskName;
    private String description;
    private boolean completed;


    public Task (String taskName, String description){
        this.id=UUID.randomUUID().toString();
        this.taskName=taskName;
        this.description=description;
        this.completed=isCompleted();
    }

}
