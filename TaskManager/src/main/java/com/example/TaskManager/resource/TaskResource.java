package com.example.TaskManager.resource;

import com.example.TaskManager.dto.TaskDTO;
import com.example.TaskManager.service.TaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/task")
public class TaskResource {

    final private TaskService service;

    public TaskResource(TaskService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<TaskDTO>> findAll() {
        List<TaskDTO> list = service.findAllPaged();
        return ResponseEntity.ok().body(list);
    }
}

