package com.example.tasks_manaager.service;

import com.example.tasks_manaager.models.Task.Task;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface TaskService {
    void saveTask(Task task);

    Task getTaskById(Long taskId);

    List<Task> findAllTasks();

    Page<Task> findActiveTasks(Pageable pageable);

}
