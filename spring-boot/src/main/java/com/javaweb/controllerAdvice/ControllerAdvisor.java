package com.javaweb.controllerAdvice;

import java.util.ArrayList;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.javaweb.model.ErrotResponseDTO;

import org.springframework.web.bind.annotation.ExceptionHandler;
import customexception.FieldRequiredException;
@ControllerAdvice
public class ControllerAdvisor extends ResponseEntityExceptionHandler {
	@ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<Object> handleArithmeticException(
            ArithmeticException ex,  WebRequest request) {
			ErrotResponseDTO err =new ErrotResponseDTO();
			err.setErrot(ex.getMessage());
			ArrayList<String> list =new ArrayList<>();
			list.add("so nguyen k chia dc cho 0");
			err.setList(list);
        return new ResponseEntity<>(err, HttpStatus.INTERNAL_SERVER_ERROR);
    }
	@ExceptionHandler(FieldRequiredException.class)
    public ResponseEntity<Object> handleFieldRequiredException(
    		FieldRequiredException ex,  WebRequest request) {
			ErrotResponseDTO err =new ErrotResponseDTO();
			err.setErrot(ex.getMessage());
			ArrayList<String> list =new ArrayList<>();
			list.add("them name vao di");
			err.setList(list);
        return new ResponseEntity<>(err, HttpStatus.BAD_GATEWAY);
    }
}
