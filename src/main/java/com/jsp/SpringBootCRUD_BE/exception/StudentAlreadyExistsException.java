package com.jsp.SpringBootCRUD_BE.exception;

public class StudentAlreadyExistsException  extends RuntimeException {
    public StudentAlreadyExistsException(String message) {
        super(message);
    }
}
