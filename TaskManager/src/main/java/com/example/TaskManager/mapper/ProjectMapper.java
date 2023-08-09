package com.example.TaskManager.mapper;

import com.example.TaskManager.dto.ProjectDTO;
import com.example.TaskManager.dto.ProjectInsertDTO;
import com.example.TaskManager.entities.Project;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProjectMapper {
    ProjectDTO toDTO(Project projectEntity);

    Project toEntity(ProjectDTO projectDTO);

    Project toEntityInsert(ProjectInsertDTO projectInsertDTO);
}
