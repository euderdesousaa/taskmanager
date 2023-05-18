package com.example.TaskManager.service;

import com.example.TaskManager.dto.TaskDTO;
import com.example.TaskManager.entities.Task;
import com.example.TaskManager.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskService {

     final private TaskRepository repository;

    public TaskService(TaskRepository repository) {
        this.repository = repository;
    }

    public List<TaskDTO> findAllPaged() {
        List<Task> list = repository.findAll();
        return list.stream().map(x -> new TaskDTO(x)).collect(Collectors.toList());
    }
}
