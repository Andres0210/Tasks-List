package com.example.tasks_manaager.models.Task;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tasks")
public class Task {

    // Atributes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private Boolean active;
    @Enumerated(EnumType.STRING)
    private State state;
    @Enumerated(EnumType.STRING)
    private Priority priority;

    //Constructors
    public Task(RegisterTaskDTO registerTaskDTO){
        this.active = true;
        this.name = registerTaskDTO.name();
        this.description = registerTaskDTO.description();
        this.state = registerTaskDTO.state();
        this.priority = registerTaskDTO.priority();
    }

    //Methods

    // Actualizar los datos de una tarea

    public void updateDataTask(UpdateTaskDTO updateTaskDTO){
        if(updateTaskDTO.name() != null){
            this.name = updateTaskDTO.name();
        }
        if(updateTaskDTO.description() != null){
            this.description = updateTaskDTO.description();
        }
        if(updateTaskDTO.state() != null){
            this.state = updateTaskDTO.state();
        }
        if(updateTaskDTO.priority() != null){
            this.priority= updateTaskDTO.priority();
        }
    }

    //Cambia el estado de la tarea a desactivado para que no se muestre en la lista
    public void disableTask(){
        this.active = false;
    }


}
