package com.example.TaskManager.dto;


import com.example.TaskManager.entities.Project;
import com.example.TaskManager.entities.Task;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data

public class TaskDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;

    @ManyToOne
    @JsonIgnore
    private Project project;


    public TaskDTO(Task entity) {
        this.id = entity.getId();
        this.description = entity.getDescription();
        this.project = entity.getProject();
    }

    public TaskDTO() {
    }

    public TaskDTO(Project entity) {
        title = entity.getName();
        description = entity.getProjectDescription();
    }
}
