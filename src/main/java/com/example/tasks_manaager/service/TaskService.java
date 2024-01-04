package com.example.tasks_manaager.service;

import com.example.tasks_manaager.models.Task.Task;

import java.util.List;

public interface TaskService {
    void saveTask(Task task);
    Task getTaskById(Long taskId);
    List<Task> findAllTasks();

}
