package com.example.TaskManager.dto;

import com.example.TaskManager.entities.Task;
import com.example.TaskManager.entities.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Email
    private String email;

    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Task> taskList = new ArrayList<>();

    public UserDTO(User entity) {
        name = entity.getName();
        id = entity.getId();
        email = entity.getEmail();
        taskList = entity.getTaskList();
    }

}
