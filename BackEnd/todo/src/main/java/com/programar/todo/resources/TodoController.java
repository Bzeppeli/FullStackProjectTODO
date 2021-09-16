package com.programar.todo.resources;

import com.programar.todo.domain.Todo;
import com.programar.todo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/todos")
public class TodoController {

    @Autowired
    private TodoService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Todo> findById(@PathVariable Integer id){
        return ResponseEntity.ok(service.findById(id));
    }

    @GetMapping(value = "/list-open")
    public ResponseEntity<List<Todo>> ListOpened(){
        return ResponseEntity.ok(service.getAllOpened());
    }

    @GetMapping(value = "/list-close")
    public ResponseEntity<List<Todo>> ListClosed(){
        return ResponseEntity.ok(service.getAllClosed());
    }

    @GetMapping(value = "/list")
    public ResponseEntity<List<Todo>> listAll(){
        return ResponseEntity.ok(service.getAll());
    }

    @PostMapping
    public ResponseEntity<Todo> postTodo(@RequestBody Todo todo){
        todo.setId(null);
        service.saveTodo(todo);
        return ResponseEntity.ok(todo);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Todo> updateTodo (@PathVariable Integer id, @RequestBody Todo todo){
        return ResponseEntity.ok(service.updateTodo(id,todo));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        service.deleteTodo(id);
        return ResponseEntity.noContent().build();
    }


}
