package com.example.TaskManager.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_user")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String password;

    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL, fetch=FetchType.LAZY)
    private List<Task> taskList = new ArrayList<>();

    @OneToMany(mappedBy = "manager",  cascade = CascadeType.ALL, fetch=FetchType.LAZY)
    private List<Project> projectList = new ArrayList<>();
}
