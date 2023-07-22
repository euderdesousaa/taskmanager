package com.example.TaskManager.dto;

import com.example.TaskManager.entities.enums.Status;
import com.example.TaskManager.entities.Project;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
public class ProjectDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private LocalDate init_date;
    private LocalDate end_date;

    @Enumerated(EnumType.STRING)
    private Status status;

    @Column(columnDefinition = "TEXT")
    private String description;

    public ProjectDTO(Project entity){
        this.id = entity.getId();
        this.name = entity.getName();
        this.description = entity.getDescription();
        this.status = entity.getStatus();
        this.init_date = entity.getInit_date();
        this.end_date = entity.getEnd_date();
    }

    public ProjectDTO(){}

}
