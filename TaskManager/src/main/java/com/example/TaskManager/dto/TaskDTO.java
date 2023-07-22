package com.example.TaskManager.dto;


import com.example.TaskManager.entities.enums.Priority;
import com.example.TaskManager.entities.Project;
import com.example.TaskManager.entities.Task;
import com.example.TaskManager.entities.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TaskDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    private Project project;

    @ManyToOne
    private User owner;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Enumerated(EnumType.STRING)
    private Priority priority;

    public TaskDTO(){}

    public TaskDTO(Task entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.description = entity.getDescription();
        this.owner = entity.getOwner();
        this.priority = entity.getPriority();
        this.project = entity.getProject();
    }

    public TaskDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
