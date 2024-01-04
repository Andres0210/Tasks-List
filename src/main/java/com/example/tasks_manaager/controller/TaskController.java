package com.example.tasks_manaager.controller;

import com.example.tasks_manaager.models.Task.RegisterTaskDTO;
import com.example.tasks_manaager.models.Task.Task;
import com.example.tasks_manaager.models.Task.TaskResponsetDTO;
import com.example.tasks_manaager.models.Task.UpdateTaskDTO;
import com.example.tasks_manaager.service.TaskService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    // Routes

    /* Create Tasks*/

    @PostMapping
    public ResponseEntity createTask(@RequestBody @Valid RegisterTaskDTO registerTaskDTO,
                                     UriComponentsBuilder uriComponentsBuilder) {
        Task task = new Task(registerTaskDTO);
        taskService.saveTask(task);
        TaskResponsetDTO taskResponsetDTO = new TaskResponsetDTO(task);
        URI url = uriComponentsBuilder.path("/tasks/{id}").buildAndExpand(task.getId()).toUri();
        return ResponseEntity.created(url).body(taskResponsetDTO);
    }

    /*listado de todas las tareas*/

    @GetMapping
    public ResponseEntity<Page<TaskResponsetDTO>> getAllTasks(Pageable pageable) {
        Page<TaskResponsetDTO> tasks = taskService.findActiveTasks(pageable).map(TaskResponsetDTO::new);
        return ResponseEntity.ok(tasks);
    }

    /*Me lista una tarea por id para acceder al detalle*/
    @GetMapping("/{taskId}")
    public ResponseEntity getTaskById(@PathVariable Long taskId) {
        Task task = taskService.getTaskById(taskId);
        TaskResponsetDTO taskResponsetDTO = new TaskResponsetDTO(task);
        return ResponseEntity.ok(taskResponsetDTO);
    }

    /* Me permite modificar los datos, también se puede acceder a esta ruta para cambiar el estado*/
    @PutMapping
    @Transactional
    public ResponseEntity updateTask(@RequestBody @Valid UpdateTaskDTO updateTaskDTO) {
        Task task = taskService.getTaskById(updateTaskDTO.id());
        task.updateDataTask(updateTaskDTO);
        TaskResponsetDTO taskResponsetDTO = new TaskResponsetDTO(task);
        return ResponseEntity.ok(taskResponsetDTO);

    }

    /*Borrado logico: me desactiva una tarea y no la muestra en la lista*/

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deleteTask(@PathVariable Long id) {
        Task task = taskService.getTaskById(id);
        task.disableTask();
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Task deleted correctly");
        return ResponseEntity.ok(response);
    }


}
