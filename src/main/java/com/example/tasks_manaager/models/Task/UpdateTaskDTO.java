package com.example.tasks_manaager.models.Task;

import jakarta.validation.constraints.NotNull;

public record UpdateTaskDTO(@NotNull Long id, String name, String description, State state, Priority priority) {
}
