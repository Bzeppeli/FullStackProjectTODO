package com.programar.todo.Exceptions;

public class ObjectNotFoundExceptions extends RuntimeException{

    public ObjectNotFoundExceptions(String message) {
        super(message);
    }

    public ObjectNotFoundExceptions(String message, Throwable cause) {
        super(message, cause);
    }
}
