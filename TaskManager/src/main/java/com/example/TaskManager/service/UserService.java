package com.example.TaskManager.service;

import com.example.TaskManager.dto.UserDTO;
import com.example.TaskManager.dto.UserInsertDTO;
import com.example.TaskManager.entities.User;
import com.example.TaskManager.repository.UserRepository;
import com.example.TaskManager.service.exceptions.DatabaseException;
import com.example.TaskManager.service.exceptions.EntityNotFoundException;
import com.example.TaskManager.service.exceptions.ResourceNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }


    @Transactional(readOnly = true)
    public List<UserDTO> findAllPaged() {
        List<User> list = repository.findAll();
        return list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
    }

    public UserDTO findById(Long id) {
        Optional<User> obj = repository.findById(id);
        User entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity Not Found"));
        return new UserDTO(entity);
    }

    public void delete(Long id) {
        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException("id not found" + id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Integrity violation");
        }
    }

    public UserDTO update(Long id, UserDTO dto) {
        try {
            User entity = repository.getReferenceById(id);
            copyDTOEntity(dto, entity);
            entity = repository.save(entity);
            return new UserDTO(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("id Not found" + id);
        }
    }

    public UserDTO insert(UserInsertDTO dto) {
        User entity = new User();
        copyDTOEntity(dto, entity);
        entity = repository.save(entity);
        return new UserDTO(entity);
    }

    private void copyDTOEntity(UserDTO dto, User entity) {
        entity.setName(dto.getName());
        entity.setEmail(dto.getEmail());
    }

}
