package com.example.TaskManager.resource;

import com.example.TaskManager.dto.ProjectDTO;
import com.example.TaskManager.dto.ProjectInsertDTO;
import com.example.TaskManager.entities.Task;
import com.example.TaskManager.service.ProjectService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/projects")
@RequiredArgsConstructor
public class ProjectResource {

    private final ProjectService service;

    @PostMapping("/create-project")
    public ResponseEntity<ProjectDTO> insertProject(@Valid @RequestBody ProjectInsertDTO dto) {
        ProjectDTO newDTO = service.insertProject(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").
                buildAndExpand(newDTO.getId()).toUri();
        return ResponseEntity.created(uri).body(newDTO);
    }

    @GetMapping("/listProject/{projectId}")
    public ResponseEntity<ProjectDTO> getProjectById(@PathVariable Long projectId) {
        ProjectDTO dto = service.getProjectById(projectId);
        return ResponseEntity.ok().body(dto);
    }

    @PostMapping("/{projectId}/tasks")
    public void addTaskToProject(@PathVariable Long projectId, @RequestBody Task task) {
        service.addTaskToProject(projectId, task);
    }

    @DeleteMapping("/{projectId}/tasks/{taskId}")
    public ResponseEntity<String> deleteTask(@PathVariable Long taskId) {
        service.deleteTaskFromProject(taskId);
        return ResponseEntity.ok("Tarefa excluída com sucesso");
    }

}
