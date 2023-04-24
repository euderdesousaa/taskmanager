package com.example.TaskManager.dto;

import com.example.TaskManager.entities.User;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserDTO {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_user;

    private String name;
    private String email;

    public UserDTO(User entity) {
        name = entity.getName();
        id_user = entity.getId_user();
        email = entity.getEmail();
    }

    public UserDTO(Long id_user, String name, String email) {
        this.id_user = id_user;
        this.name = name;
        this.email = email;
    }
}
