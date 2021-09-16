package com.programar.todo.service.impl;

import com.programar.todo.Exceptions.ObjectNotFoundExceptions;
import com.programar.todo.domain.Todo;

import com.programar.todo.repositories.TodoRepository;
import com.programar.todo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class TodoServiceImpl implements TodoService {

    @Autowired
    private TodoRepository repository;

    @Override
    public Todo findById(Integer id) {
        Optional<Todo> optTodo = repository.findById(id);
        return optTodo.orElseThrow(() -> new ObjectNotFoundExceptions("Objeto não Encontrado ID: " + "Tipo: " + Todo.class.getName()));
    }

    @Override
    public List<Todo> getAllOpened(){
        List<Todo> list = repository.findAllOpen();
        return list;
    }

    @Override
    public List<Todo> getAllClosed() {
        List<Todo> list = repository.findAllClose();
        return list;
    }

    @Override
    public List<Todo> getAll() {
        List<Todo> list = repository.findAll();
        return list;
    }

    @Override
    public Todo saveTodo(Todo todo){
        repository.save(todo);
        return todo;
    }

    @Override
    public Todo updateTodo(Integer id, Todo todo){
        Todo newTodo = findById(id);
        newTodo.setTitulo(todo.getTitulo());
        newTodo.setDescricao(todo.getDescricao());
        newTodo.setDataParaFinalizar(todo.getDataParaFinalizar());
        newTodo.setFinalizado(todo.getFinalizado());
        repository.save(newTodo);
        return newTodo;

    }

    @Override
    public void deleteTodo(Integer id){
        repository.deleteById(id);
    }
}
