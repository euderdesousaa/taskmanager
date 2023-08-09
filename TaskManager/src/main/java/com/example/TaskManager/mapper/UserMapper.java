package com.example.TaskManager.mapper;

import com.example.TaskManager.dto.UserDTO;
import com.example.TaskManager.dto.UserInsertDTO;
import com.example.TaskManager.entities.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDTO toDTO(User entity);

    User toEntity(UserDTO dto);

    User toEntityInsert(UserInsertDTO insertDTO);
}
