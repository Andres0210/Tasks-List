package com.example.tasks_manaager.repository;

import com.example.tasks_manaager.models.Task.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
