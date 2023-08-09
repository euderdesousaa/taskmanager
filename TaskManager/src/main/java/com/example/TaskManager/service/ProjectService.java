package com.example.TaskManager.service;

import com.example.TaskManager.dto.ProjectDTO;
import com.example.TaskManager.dto.ProjectInsertDTO;
import com.example.TaskManager.entities.Project;
import com.example.TaskManager.entities.Task;
import com.example.TaskManager.mapper.ProjectMapper;
import com.example.TaskManager.repository.ProjectRepository;
import com.example.TaskManager.repository.TaskRepository;
import com.example.TaskManager.service.exceptions.DatabaseException;
import com.example.TaskManager.service.exceptions.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProjectService {

    private final ProjectRepository projectRepository;
    private final TaskRepository taskRepository;
    private final ProjectMapper projectMapper;

    public ProjectDTO insertProject(ProjectInsertDTO dto) {
        Project save = projectRepository.save(projectMapper.toEntityInsert(dto));
        return projectMapper.toDTO(save);
    }

    @Transactional(readOnly = true)
    public ProjectDTO getProjectById(Long projectId) {
        Optional<Project> obj = projectRepository.findById(projectId);
        Project entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity Not Found"));
        return new ProjectDTO(entity);
    }

    public void addTaskToProject(Long projectId, Task task) {
        Project project = projectRepository.findById(projectId).orElseThrow(() -> new IllegalArgumentException("Project not Found"));
        project.setTasks(project.getTasks());
        task.setProject(project);
        taskRepository.save(task);
    }

    public void deleteTaskFromProject(Long taskId) {
        try {
            taskRepository.deleteById(taskId);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException("id not found" + taskId);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Integrity violation");
        }
    }

}
