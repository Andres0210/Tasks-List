package com.example.tasks_manaager.controller;

import com.example.tasks_manaager.models.Task.RegisterTaskDTO;
import com.example.tasks_manaager.models.Task.Task;
import com.example.tasks_manaager.models.Task.TaskResponsetDTO;
import com.example.tasks_manaager.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    // Routes

    // Create Tasks

    @PostMapping
    public void createTask(@RequestBody @Valid RegisterTaskDTO registerTaskDTO){
        Task task = new Task(registerTaskDTO);
        taskService.saveTask(task);
    }

    // listado de todas las tareas

    @GetMapping
    public List<TaskResponsetDTO> getAllTasks(){
       List<TaskResponsetDTO> tasks = taskService.findAllTasks().stream().map(TaskResponsetDTO::new).toList();
       return tasks;
    }
@GetMapping("/{taskId}")
    public TaskResponsetDTO getTaskById(@PathVariable Long taskId) {
        Task task = taskService.getTaskById(taskId);
        TaskResponsetDTO taskResponsetDTO = new TaskResponsetDTO(task);
        return taskResponsetDTO;
    }

    //Este comoentario se realizó en el feature/terminar-rutas y quiero probar algo



}
