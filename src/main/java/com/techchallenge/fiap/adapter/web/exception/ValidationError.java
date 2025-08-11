package com.techchallenge.fiap.adapter.web.exception;

import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StandardError{

	private List<FieldMessage> errors = new ArrayList<>();
	
	public ValidationError(Integer status, String message) {
		super(status, message);
	}

	public List<FieldMessage> getErrors() {
		return errors;
	}

	public void addFieldError(String fieldName, String message) {
		errors.add(new FieldMessage(fieldName, message));
	}
	
}
