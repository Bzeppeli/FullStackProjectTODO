package com.programar.todo.service.impl;

import com.programar.todo.domain.Todo;
import com.programar.todo.repositories.TodoRepository;
import com.programar.todo.service.DBservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

@Service
public class DBServiceImpl implements DBservice {

    @Autowired
    public TodoRepository repository;

    @Override
    public void instanciaBaseDeDB() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        Todo t1 = new Todo(null, "Estudar", "Estudar Spring Boot 2 e Angular 12", sdf.parse("25/03/2022"), false);


        Todo t2 = new Todo(null, "Jogar", "Jogar Ghost of tsushima", sdf.parse("25/03/2022"), false);


        Todo t3 = new Todo(null, "Ler", "Terminar de Ler HellBlazer", sdf.parse("18/09/2022"), true);


        Todo t4 = new Todo(null, "Correr", "Correr 10km", sdf.parse("18/03/2022"), false);
        repository.saveAll(Arrays.asList(t1, t2, t3, t4));
    }
}
