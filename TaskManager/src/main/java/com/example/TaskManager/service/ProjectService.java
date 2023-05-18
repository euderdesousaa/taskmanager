package com.example.TaskManager.service;

import com.example.TaskManager.dto.ProjectDTO;
import com.example.TaskManager.entities.Project;
import com.example.TaskManager.repository.ProjectRepository;
import com.example.TaskManager.service.exceptions.DatabaseException;
import com.example.TaskManager.service.exceptions.EntityNotFoundException;
import com.example.TaskManager.service.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository repository;

    public List<ProjectDTO> findAllPaged() {
        List<Project> list = repository.findAll();
        return list.stream().map(x -> new ProjectDTO(x)).collect(Collectors.toList());
    }

    public ProjectDTO findById(Long id) {
        Optional<Project> obj = repository.findById(id);
        Project entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));

        return new ProjectDTO(entity);
    }

    public ProjectDTO update(Long id, ProjectDTO dto) {
        try {
            Project entity = repository.getReferenceById(id);
            copyDTOEntity(dto, entity);
            entity = repository.save(entity);
            return new ProjectDTO(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("id Not found" + id);
        }
    }

    public ProjectDTO insert(ProjectDTO dto) {
        Project entity = new Project();
        copyDTOEntity(dto, entity);
        entity = repository.save(entity);
        return new ProjectDTO(entity);
    }

    public void delete(Long id) {
        try {
            repository.deleteById(id);
        } catch (
                EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException("id not found" + id);
        } catch (
                DataIntegrityViolationException e) {
            throw new DatabaseException("Integrity violation");
        }
    }

    private void copyDTOEntity(ProjectDTO dto, Project entity) {
        entity.setName(dto.getName());
        entity.setDescription(dto.getDescription());
        entity.setStatus(dto.getStatus());
        entity.setInit_date(dto.getInit_date());
        entity.setEnd_date(dto.getEnd_date());
    }
}
