package com.programar.todo.service.impl;

import com.programar.todo.domain.Todo;
import com.programar.todo.repositories.TodoRepository;
import com.programar.todo.service.DBservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

@Service
public class DBServiceImpl implements DBservice {

    @Autowired
    public TodoRepository repository;

    @Override
    public void instanciaBaseDeDB() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        Todo t1 = new Todo(null, "Estudar", "Estudar Spring Boot 2 e Angular 12", LocalDateTime.parse("25/03/2022 10:23", formatter), false);


        Todo t2 = new Todo(null, "Jogar", "Jogar Ghost of tsushima", LocalDateTime.parse("25/03/2022 10:23", formatter), false);


        Todo t3 = new Todo(null, "Ler", "Terminar de Ler HellBlazer", LocalDateTime.parse("18/09/2022 10:23", formatter), true);


        Todo t4 = new Todo(null, "Correr", "Correr 10km", LocalDateTime.parse("18/03/2022 16:23", formatter), false);
        repository.saveAll(Arrays.asList(t1, t2, t3, t4));
    }
}
