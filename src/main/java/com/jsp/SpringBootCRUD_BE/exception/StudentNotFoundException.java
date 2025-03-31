package com.jsp.SpringBootCRUD_BE.exception;

public class StudentNotFoundException extends RuntimeException {
	
    public StudentNotFoundException(String message) {
        super(message);
}
}