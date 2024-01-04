package com.example.tasks_manaager.models.Task;

public record TaskResponsetDTO(Long id, String name, String description, String state, String priority) {
    public TaskResponsetDTO(Task task) {
        this(task.getId(), task.getName(), task.getDescription(), task.getState().toString(), task.getPriority().toString());
    }
}
