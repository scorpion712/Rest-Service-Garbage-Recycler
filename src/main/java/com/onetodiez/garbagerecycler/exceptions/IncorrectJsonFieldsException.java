package com.onetodiez.garbagerecycler.exceptions;

/**
 * 
 * @author Oneto, Fernando
 * @author Diez, Lautaro
 * 
 */
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class IncorrectJsonFieldsException extends RuntimeException {
	
	private static final String message = "There some error on fields! Fix it and try again. "
			+ "Hay algunos errores en los campos! Revise e intente nuevamente.";

	public IncorrectJsonFieldsException() {
		super(message);
	}

}
