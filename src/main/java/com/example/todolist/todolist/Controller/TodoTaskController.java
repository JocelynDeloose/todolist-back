package com.example.todolist.todolist.Controller;

import com.example.todolist.todolist.Models.TodoTask;
import com.example.todolist.todolist.Repository.TodoTaskRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@CrossOrigin(origins = "*")
@RestController
public class TodoTaskController {

    private final TodoTaskRepository repository;


    public TodoTaskController(TodoTaskRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/todotask")
    public List<TodoTask> getAll() {
        return this.repository.findAll();
    }

    @GetMapping("/todotask/{id}")
    public ResponseEntity<TodoTask> getById(@PathVariable Long id) {

        Optional<TodoTask> optionalTodoTask = repository.findById(id);

        if (optionalTodoTask.isPresent()) {
            TodoTask todoTask = optionalTodoTask.get();

            return ResponseEntity.ok().body(todoTask);
        }

        return ResponseEntity.notFound().build();
    }

    @PostMapping("/todotaskpost")
    public TodoTask postTodoTask(@RequestBody TodoTask todoTask) {
        System.out.println("@@@@@@@@@@@@ it's done??");
        return this.repository.save(todoTask);
    }

    @PutMapping("/todotask/{id}")
    public ResponseEntity<TodoTask> update(@PathVariable Long id, @RequestBody TodoTask updateTodoTask) {
        Optional<TodoTask> optionalTodoTask = repository.findById(id);

        if (optionalTodoTask.isPresent()) {

            TodoTask todoTask = optionalTodoTask.get();
            todoTask.setName(updateTodoTask.getName());
            todoTask.setDescription(updateTodoTask.getDescription());
            todoTask.setPriority(updateTodoTask.getPriority());

            return ResponseEntity.ok(repository.save(todoTask));
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/todotask/{id}")
    public boolean delete(@PathVariable Long id) {
        repository.deleteById(id);
        return true;
    }
}
