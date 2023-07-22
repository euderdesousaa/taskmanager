package com.example.TaskManager.entities.Enuns;

import lombok.Getter;

@Getter
public enum Priority {
        IMPORTANT(1),
        MEDIUM_PRIORITY(2),
        LOW_PRIORITY(3);

        private final int valor;
        Priority(int valor){
            this.valor = valor;
        }
    }

