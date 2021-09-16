package com.programar.todo.service;


import com.programar.todo.domain.Todo;

import java.util.List;
import java.util.Optional;

public interface TodoService {

    Todo findById(Integer id);

    List<Todo> getAllOpened();

    List<Todo> getAllClosed();

    List<Todo> getAll();

    Todo saveTodo(Todo todo);

    Todo updateTodo(Integer id, Todo todo);

    void deleteTodo(Integer id);
}
