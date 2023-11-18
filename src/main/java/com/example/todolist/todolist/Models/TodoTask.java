package com.example.todolist.todolist.Models;

import com.example.todolist.todolist.Priority;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@Entity
public class TodoTask {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private String description;

    private Priority priority;

    public TodoTask(String name, String description, Priority priority) {

        this.name = name;
        this.description = description;
        this.priority = priority;
    }
}