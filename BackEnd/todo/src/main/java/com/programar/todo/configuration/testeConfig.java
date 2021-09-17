package com.programar.todo.configuration;

import com.programar.todo.service.DBservice;
import com.programar.todo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.text.ParseException;

@Configuration
@Profile("test")
public class testeConfig {

    @Autowired
    private DBservice service;

    @Bean
    public boolean instanciaDB() throws ParseException {
        this.service.instanciaBaseDeDB();
        return true;
    }

}
