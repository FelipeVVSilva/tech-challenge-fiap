package com.techchallenge.fiap.adapter.web.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.techchallenge.fiap.exception.CredenciaisInvalidasException;
import com.techchallenge.fiap.exception.RecursoNaoEncontradoException;
import com.techchallenge.fiap.exception.UsuarioExistenteException;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class RestExceptionHandler {

	@ExceptionHandler(RecursoNaoEncontradoException.class)
	public ResponseEntity<StandardError> recursoNaoEncontradoException(RecursoNaoEncontradoException e){
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError error = new StandardError(status.value(), e.getMessage());
		return ResponseEntity.status(status).body(error);
	}
	
	@ExceptionHandler(UsuarioExistenteException.class)
	public ResponseEntity<StandardError> usuarioExistenteException(UsuarioExistenteException e){
		HttpStatus status = HttpStatus.BAD_REQUEST;
		StandardError error = new StandardError(status.value(), e.getMessage());
		return ResponseEntity.status(status).body(error);
	}
	
	@ExceptionHandler(CredenciaisInvalidasException.class)
	public ResponseEntity<StandardError> credenciaisInvalidasException(CredenciaisInvalidasException e){
		HttpStatus status = HttpStatus.BAD_REQUEST;
		StandardError error = new StandardError(status.value(), e.getMessage());
		return ResponseEntity.status(status).body(error);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ValidationError> validation(MethodArgumentNotValidException e, HttpServletRequest request){
		
		HttpStatus status = HttpStatus.UNPROCESSABLE_ENTITY;
		ValidationError error = new ValidationError(status.value(), "Erro na validação");
		
		for (FieldError f : e.getBindingResult().getFieldErrors()) {
			error.addFieldError(f.getField(), f.getDefaultMessage());
		}
		
		return ResponseEntity.status(status).body(error);
	}
	
}
