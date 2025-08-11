package com.techchallenge.fiap.exception;

public class UsuarioExistenteException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public UsuarioExistenteException(String msg) {
        super(msg);
    }
}
