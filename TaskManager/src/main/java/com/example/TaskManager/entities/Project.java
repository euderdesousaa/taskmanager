package com.example.TaskManager.entities;

import com.example.TaskManager.entities.Enuns.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_project")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    private LocalDateTime init_date;
    private LocalDateTime end_date;

    @Enumerated(EnumType.STRING)
    private Status status;

    @Column(columnDefinition = "TEXT")
    private String description;

    @ManyToOne
    private User manager;

    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL)
    private List<Task> taskList = new ArrayList<>();

}
