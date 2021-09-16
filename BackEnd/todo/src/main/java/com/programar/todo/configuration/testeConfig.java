package com.programar.todo.configuration;

import com.programar.todo.service.DBservice;
import com.programar.todo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("test")
public class testeConfig {

    @Autowired
    private DBservice service;

    @Bean
    public boolean instanciaDB(){
        this.service.instanciaBaseDeDB();
        return true;
    }

}
