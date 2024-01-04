package com.example.tasks_manaager.models.Task;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record RegisterTaskDTO(

        @NotBlank
        String name,
        @NotBlank
        String description,
        @NotNull
        State state,
        @NotNull
        Priority priority
) {
}
