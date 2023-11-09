package com.tryspring.springtodo.controller;

import com.tryspring.springtodo.models.Todo;
import com.tryspring.springtodo.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class TodoController {
    @Autowired
    private TodoRepository todoRepository;

    @GetMapping("/todo/all")
    public List<Todo> getAllTodo(){
        return todoRepository.findAll();
    }
    @GetMapping("/todo/{id}")
    public Todo getTodoById(@PathVariable int id){
        return todoRepository.findById(id);
    }
    @PostMapping("/todo")
    public List<Todo> addTodo(@RequestBody Todo todo){
        return todoRepository.insert(todo);
    }
    @PutMapping("/todo")
    public List<Todo> updateTodo(@RequestBody Todo todo){
        return todoRepository.update(todo);
    }
    @DeleteMapping("/todo/{id}")
    public  List<Todo> deleteTodoById(@PathVariable int id){
        return todoRepository.deleteTodoById(id);
    }
}

