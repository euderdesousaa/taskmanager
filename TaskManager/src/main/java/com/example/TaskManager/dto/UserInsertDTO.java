package com.example.TaskManager.dto;

import com.example.TaskManager.service.validation.UserInsertValid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@UserInsertValid
@Data
@NoArgsConstructor
public class UserInsertDTO extends UserDTO {

    @NotNull
    @Size(min = 8, max = 24)
    private String password;
}
