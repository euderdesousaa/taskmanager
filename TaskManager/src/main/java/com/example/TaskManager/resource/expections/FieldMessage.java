package com.example.TaskManager.resource.expections;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class FieldMessage {
    private String fieldName;
    private String message;
}
