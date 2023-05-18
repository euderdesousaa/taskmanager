package com.example.TaskManager.dto;

import com.example.TaskManager.entities.Task;
import com.example.TaskManager.entities.User;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class UserDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;

    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL, fetch=FetchType.LAZY)
    private List<Task> taskList = new ArrayList<>();

    public UserDTO(User entity) {
        name = entity.getName();
        id = entity.getId();
        email = entity.getEmail();
        taskList = entity.getTaskList();
    }

    public UserDTO(Long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }
}
