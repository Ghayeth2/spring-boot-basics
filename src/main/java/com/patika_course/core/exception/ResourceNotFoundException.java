package com.patika_course.core.exception;

public class ResourceNotFoundException extends RuntimeException{
    private static final Long serialVersionUID=1L;

    public ResourceNotFoundException(String message){
        super(message);

    }
}
