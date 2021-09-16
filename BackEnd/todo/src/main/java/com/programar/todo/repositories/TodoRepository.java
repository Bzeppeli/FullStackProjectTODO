package com.programar.todo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.programar.todo.domain.Todo;

import java.util.List;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Integer> {

    @Query("SELECT obj FROM Todo obj WHERE obj.finalizado = false ORDER BY obj.dataParaFinalizar")
    List<Todo> findAllOpen();

    @Query("SELECT obj FROM Todo obj WHERE obj.finalizado = true ORDER BY obj.dataParaFinalizar")
    List<Todo> findAllClose();

}
