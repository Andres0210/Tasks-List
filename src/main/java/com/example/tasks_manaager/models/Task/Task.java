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
    @Enumerated(EnumType.STRING)
    private State state;
    @Enumerated(EnumType.STRING)
    private Priority priority;

    //Constructors
    public Task(RegisterTaskDTO registerTaskDTO){
        this.name = registerTaskDTO.name();
        this.description = registerTaskDTO.description();
        this.state = registerTaskDTO.state();
        this.priority = registerTaskDTO.priority();
    }

    //Methods


}
