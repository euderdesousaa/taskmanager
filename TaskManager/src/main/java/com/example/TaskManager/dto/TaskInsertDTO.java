package com.example.TaskManager.dto;

import com.example.TaskManager.entities.Project;
import com.example.TaskManager.entities.Task;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TaskInsertDTO extends TaskDTO {
    public TaskInsertDTO(Project entity) {
        super(entity);
    }

    public TaskInsertDTO(Task entity) {
        super(entity);
    }
}
