package com.programar.todo.Exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class StandardError implements Serializable {
    private Long timestamp;
    private Integer status;
    private String message;
}
