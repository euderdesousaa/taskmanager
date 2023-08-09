package com.example.TaskManager.dto;

import com.example.TaskManager.entities.User;
import com.example.TaskManager.entities.enums.Roles;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String login;

    @Email
    private String email;

    private Roles role;

    public UserDTO(User entity) {
        name = entity.getName();
        id = entity.getId();
        email = entity.getEmail();
        login = entity.getLogin();
    }

}
