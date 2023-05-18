package com.example.TaskManager.resource;

import com.example.TaskManager.dto.ProjectDTO;
import com.example.TaskManager.service.ProjectService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/project")
public class ProjectResource {

    @Autowired
    private ProjectService service;

    @GetMapping
    public ResponseEntity<List<ProjectDTO>> findAll() {
        List<ProjectDTO> list = service.findAllPaged();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ProjectDTO> findById(@PathVariable Long id) {
        ProjectDTO project = service.findById(id);
        return ResponseEntity.ok().body(project);
    }

    @PostMapping
    public ResponseEntity<ProjectDTO> insert(@RequestBody ProjectDTO dto) {
        dto = service.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").
                buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<ProjectDTO> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<ProjectDTO> update(@PathVariable Long id, @Valid @RequestBody ProjectDTO dto) {
        ProjectDTO newDto = service.update(id, dto);
        return ResponseEntity.ok().body(newDto);
    }
}
