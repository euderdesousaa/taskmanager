package com.example.TaskManager.dto;

import com.example.TaskManager.entities.Project;
import com.example.TaskManager.entities.Task;
import com.example.TaskManager.entities.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProjectDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private User owner;

    @Column(columnDefinition = "TEXT")
    private String projectDescription;

    @OneToMany(mappedBy = "project", fetch = FetchType.EAGER)
    private List<Task> tasks;

    public ProjectDTO(Project entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.owner = entity.getOwner();
        this.tasks = entity.getTasks();
        this.projectDescription = entity.getProjectDescription();
    }

}
