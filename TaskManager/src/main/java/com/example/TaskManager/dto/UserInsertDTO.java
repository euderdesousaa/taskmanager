package com.example.TaskManager.dto;

import com.example.TaskManager.service.validation.UserInsertValid;
import lombok.Getter;
import lombok.Setter;

@UserInsertValid
@Getter
@Setter
public class UserInsertDTO extends UserDTO{
    private String password;

    public UserInsertDTO() {
        super();
    }
}
