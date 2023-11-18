package com.example.todolist.todolist.Repository;

import com.example.todolist.todolist.Models.TodoTask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoTaskRepository extends JpaRepository<TodoTask, Long> {


}
