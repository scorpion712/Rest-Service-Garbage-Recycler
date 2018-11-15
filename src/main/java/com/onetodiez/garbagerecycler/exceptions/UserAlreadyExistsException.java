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
public class UserAlreadyExistsException extends RuntimeException {
	
	private static final String USER_ALREADY_EXISTS = "Username already exists! Try again with another username, "
			+ "El nombre de usuario ya existe! Intente nuevamente con un nuevo nombre de usuario.";
	
	public UserAlreadyExistsException () {
		super(USER_ALREADY_EXISTS);
	}
}
